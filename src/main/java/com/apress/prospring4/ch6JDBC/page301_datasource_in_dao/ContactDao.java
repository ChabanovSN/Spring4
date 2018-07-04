package com.apress.prospring4.ch6JDBC.page301_datasource_in_dao;

import com.apress.prospring4.ch6JDBC.page288jdbc_ussuall_using.Contact;

import java.util.List;

public interface ContactDao {
    String findLastNameById(Long id);
    List<Contact> findAll();
}
