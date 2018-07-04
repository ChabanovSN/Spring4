package com.apress.prospring4.ch3.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent msgEvent = (MessageEvent) messageEvent;
        System.out.println("Received: "+msgEvent.getMessage());

    }


}
