package com.apress.prospring4.ch3.annotation;


import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericApplicationContext context =
                new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) context).load("classpath:springChp3/app-context-annotation.xml");
        context.refresh();

        MessageProvider provider = (CongiguradleMessageProvider) context.getBean("providerConfig",CongiguradleMessageProvider.class);
        System.out.println(provider.getMessage());
//        MessageRender render = context.getBean("messageRenderer", StandardOutMessageRenderer.class);
//     //   render.setMessageProvider(provider);
//            render.render();
    }
}
