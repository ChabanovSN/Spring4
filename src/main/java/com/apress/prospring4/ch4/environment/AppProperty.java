package com.apress.prospring4.ch4.environment;

public class AppProperty {
    private String applicationHome;
    private String userHome;

    public String getApplicationHome() {
        return applicationHome;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setApplicationHome(String applicationHome) {

        this.applicationHome = applicationHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }
}