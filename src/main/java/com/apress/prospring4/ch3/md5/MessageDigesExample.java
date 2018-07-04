package com.apress.prospring4.ch3.md5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigesExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("springChp3/app-context-digest.xml");
        ctx.refresh();

        MessageDigester digester = ctx.getBean("digester",MessageDigester.class);
        digester.digest("hello world");
    }
}
