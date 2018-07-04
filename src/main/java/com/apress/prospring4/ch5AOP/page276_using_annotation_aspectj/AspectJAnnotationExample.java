package com.apress.prospring4.ch5AOP.page276_using_annotation_aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx= new GenericXmlApplicationContext();
        ctx.load("ch5XML/page279-annotation.xml");
        ctx.refresh();
        MyBean myBean = (MyBean) ctx.getBean("myBean");

        myBean.execute();
    }
}
