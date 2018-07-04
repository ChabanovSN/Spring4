package com.apress.prospring4.ch3.message;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringCompWithConstructor {
    public static void main(String[] args) {
        GenericApplicationContext context =
                new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) context).load("classpath:springChp3/app-context-consructor.xml");
        context.refresh();

        MessageProvider provider = context.getBean("messageProviderConstr",CongiguradleMessageProvider.class);
        System.out.println(provider.getMessage());
//        MessageRender render = context.getBean("messageRenderer", StandardOutMessageRenderer.class);
//        //   render.setMessageProvider(provider);
//        render.render();
    }
}
