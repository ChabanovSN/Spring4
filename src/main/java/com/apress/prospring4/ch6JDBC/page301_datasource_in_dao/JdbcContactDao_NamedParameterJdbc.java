package com.apress.prospring4.ch6JDBC.page301_datasource_in_dao;

import com.apress.prospring4.ch6JDBC.page288jdbc_ussuall_using.Contact;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcContactDao_NamedParameterJdbc implements ContactDao,InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        MySQLErrorCodesTranslator errorTranslator =
                new MySQLErrorCodesTranslator();
        errorTranslator.setDataSource(dataSource);

    }

    @Override
    public List<Contact> findAll() {
        String sql = "select id,first_name, last_name, birth_date  from contact";
        Map<String, Contact> namedParameters = new HashMap<String, Contact>();//// ???? without this don't work. Method parameter
        return namedParameterJdbcTemplate.query(sql,namedParameters, (resultSet, i) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        });
    }

    public String findLastNameById(Long id) {
        String sql = "select last_name from contact where id= :contactId";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("contactId",id);
        return (String) namedParameterJdbcTemplate.queryForObject(sql,namedParameters,String.class);
    }

    public void afterPropertiesSet() throws Exception {
        if(dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if(namedParameterJdbcTemplate == null){
            throw new BeanCreationException("Null namedParameterJdbcTemplate on ContactDao");
        }
    }



}
