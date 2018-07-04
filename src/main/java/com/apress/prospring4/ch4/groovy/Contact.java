package com.apress.prospring4.ch4.groovy;

public class Contact {
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return
                "FirstName: " + firstName +
                ", LastName: " + lastName +
                ", age: " + age
               ;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
