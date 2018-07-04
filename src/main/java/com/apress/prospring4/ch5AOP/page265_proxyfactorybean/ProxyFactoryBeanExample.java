package com.apress.prospring4.ch5AOP.page265_proxyfactorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("ch5XML/page265-app-context-xml.xml");
        ctx.refresh();

        MyBean bean1 =(MyBean) ctx.getBean("myBean1");
        MyBean bean2 =(MyBean) ctx.getBean("myBean2");
        System.out.println("Bean1");
        bean1.execute();
        System.out.println("\nBean2");
        bean2.execute();
    }
}
