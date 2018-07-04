package com.apress.prospring4.ch3.message;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello fucking World!!!";
    }
}
