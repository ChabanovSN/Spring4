package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRender {
  private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider");
        }
        System.out.println(messageProvider.getMessage());
    }
    @Autowired
    @Qualifier("messageProvider")
    @Override
    public void setMessageProvider(MessageProvider provider) {
messageProvider=provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
