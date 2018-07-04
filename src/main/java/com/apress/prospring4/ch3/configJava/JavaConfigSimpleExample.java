package com.apress.prospring4.ch3.configJava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigSimpleExample {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRender render =
                context.getBean("messageRender",MessageRender.class);
        render.render();
    }
}
