package com.apress.prospring4.ch6JDBC.page301_datasource_in_dao;

import com.apress.prospring4.ch6JDBC.page288jdbc_ussuall_using.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class JdbcContactDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ch6JDBC/page301-app-context-datasource.xml");
        ctx.refresh();
        ContactDao contactDao = (JdbcContactDao) ctx.getBean("contactDao");
        ContactDao contactDaoNamed = (JdbcContactDao_NamedParameterJdbc) ctx.getBean("contactDaoNamed");
        System.out.println("First name for contact id 1 is: "+
        contactDao.findLastNameById(1L)+" last name "+contactDaoNamed.findLastNameById(1L));

        List<Contact>list= contactDao.findAll();
        for(Contact contact :list)  System.out.println(contact.toString());
        System.out.println("_______________________");
        list= contactDaoNamed.findAll();
        for(Contact contact :list)   System.out.println(contact.toString());


    }


}
