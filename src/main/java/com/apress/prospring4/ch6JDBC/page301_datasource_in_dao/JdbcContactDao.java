package com.apress.prospring4.ch6JDBC.page301_datasource_in_dao;

import com.apress.prospring4.ch6JDBC.page288jdbc_ussuall_using.Contact;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcContactDao implements ContactDao,InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        MySQLErrorCodesTranslator errorTranslator =
                new MySQLErrorCodesTranslator();
        errorTranslator.setDataSource(dataSource);
        this.jdbcTemplate =jdbcTemplate;
    }


    public String findLastNameById(Long id) {
        return(String) jdbcTemplate.queryForObject("select first_name from contact where id=?",
                new Object[]{id},String.class);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "select id,first_name, last_name, birth_date  from contact";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        });
    }

    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if(jdbcTemplate == null){
            throw new BeanCreationException("Null JdbcTemple on ContactDao");
        }
    }
}
