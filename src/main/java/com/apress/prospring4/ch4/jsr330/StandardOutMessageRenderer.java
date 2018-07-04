package com.apress.prospring4.ch4.jsr330;


import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("messageRenderer")
@Singleton// in Spring singleton is defaulted so this annotation don't have meaning
public class StandardOutMessageRenderer implements MessageRender {
    @Inject
    @Named("messageProvider")
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
