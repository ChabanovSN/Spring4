package com.apress.prospring4.ch5AOP.page281_singl_aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx= new GenericXmlApplicationContext();
        ctx.load(new String[]{"ch5XML/page281-app-context-xml.xml"}); ////// файл .aj  спринг не видит и ответа не нашел почему
        ctx.refresh();
       // MessageWriter writer = (MessageWriter) ctx.getBean("aspect");
        MessageWriter writer = new MessageWriter();
        writer.writeMessage();
        writer.foo();
    }
}
