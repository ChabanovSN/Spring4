package com.apress.prospring4.ch3.message;

public class CongiguradleMessageProvider implements MessageProvider {
  private String message;

    public CongiguradleMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
