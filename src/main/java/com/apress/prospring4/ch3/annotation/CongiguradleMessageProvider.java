package com.apress.prospring4.ch3.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("providerConfig")
public class CongiguradleMessageProvider implements MessageProvider {
  private String message;

  @Autowired

    public CongiguradleMessageProvider( @Value("Very difficult way") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
