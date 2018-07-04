package com.apress.prospring4.ch4.jsr330;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Example {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("springCh4XML/app-context-jsr330.xml");
        ctx.refresh();

        MessageRender render = ctx.getBean("messageRenderer", MessageRender.class);

        System.out.println(render.getMessageProvider());
    }
}
