package com.apress.prospring4.ch4.environment;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("springCh4XML/app-environment.xml");
        ctx.refresh();
        AppProperty appProperty = (AppProperty) ctx.getBean("appProperty",AppProperty.class);
        System.out.println("application.nome: "+appProperty.getApplicationHome());
        System.out.println("Userhome: "+appProperty.getUserHome());
    }
}
