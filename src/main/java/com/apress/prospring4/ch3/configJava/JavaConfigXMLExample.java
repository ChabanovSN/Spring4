package com.apress.prospring4.ch3.configJava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXMLExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springChp3/app-context-configJava.xml");
        MessageRender  render = context.getBean("messagePenderer",MessageRender.class);
        render.render();
    }
}
