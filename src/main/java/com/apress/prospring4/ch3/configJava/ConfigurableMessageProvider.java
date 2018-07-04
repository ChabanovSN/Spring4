package com.apress.prospring4.ch3.configJava;

public class ConfigurableMessageProvider implements MessageProvider {
   private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}