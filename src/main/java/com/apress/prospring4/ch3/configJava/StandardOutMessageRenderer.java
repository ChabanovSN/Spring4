package com.apress.prospring4.ch3.configJava;



public class StandardOutMessageRenderer implements MessageRender {
  private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
messageProvider=provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
