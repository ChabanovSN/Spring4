package com.apress.prospring4.ch4.jsr330;

import javax.inject.Inject;
import javax.inject.Named;

@Named("messageProvider")
public class CongiguradleMessageProvider implements MessageProvider {
  private String message = "Default message";

    public CongiguradleMessageProvider() {
    }

    @Inject
    @Named("message")
    public CongiguradleMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
