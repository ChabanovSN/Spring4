package com.apress.prospring4.ch3.message;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericApplicationContext context =
                new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) context).load("classpath:springChp3/app-context-xml.xml");
        context.refresh();

//        MessageProvider provider = context.getBean("messageProvider",HelloWorldMessageProvider.class);
//        System.out.println(provider.getMessage());
        MessageRender render = (StandardOutMessageRenderer) context.getBean("messageRenderer", StandardOutMessageRenderer.class);
        //   render.setMessageProvider(provider);
        render.render();
    }
}
