package com.apress.prospring4.ch6JDBC.page288jdbc_ussuall_using;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<ContactTelDetail> contactTelDetailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<ContactTelDetail> getContactTelDetailList() {
        return contactTelDetailList;
    }

    public void setContactTelDetailList(List<ContactTelDetail> contactTelDetailList) {
        this.contactTelDetailList = contactTelDetailList;
    }

    @Override
    public String toString() {
        return "Contact -" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
             //   ", contactTelDetailList=" + contactTelDetailList +
                '}';
    }
}
