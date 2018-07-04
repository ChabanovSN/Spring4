package com.apress.prospring4.ch5AOP.securebeen;

public class UserINfo {
    private String userName;
    private String password;

    public UserINfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
