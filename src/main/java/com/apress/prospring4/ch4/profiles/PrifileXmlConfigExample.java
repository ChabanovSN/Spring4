package com.apress.prospring4.ch4.profiles;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class PrifileXmlConfigExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx =
//                new GenericXmlApplicationContext();
//        ctx.load("classpatch:springCh4XML/highschool-config.xml");
//        ctx.refresh();
        GenericXmlApplicationContext ctx =   new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) ctx).load("springCh4XML/*-config.xml");
        ctx.refresh();
     //   ctx.getEnvironment().setActiveProfiles("kindergarten");
        ctx.getEnvironment().setActiveProfiles("highschool");
        FoodProviderService foodProviderService =
                ctx.getBean("foodProviderService",FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.providerLunchSet();
        for(Food food : lunchSet) System.out.println("Food"+food.getName());

    }
}
