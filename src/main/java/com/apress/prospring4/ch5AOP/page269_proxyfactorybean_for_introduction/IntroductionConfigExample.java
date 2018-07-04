package com.apress.prospring4.ch5AOP.page269_proxyfactorybean_for_introduction;

import com.apress.prospring4.ch5AOP.page256_introduction.page259_ismodified.IsModified;
import com.apress.prospring4.ch5AOP.page256_introduction.page259_ismodified.TargetBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class IntroductionConfigExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("ch5XML/page269-app-contex-xml.xml");
        ctx.refresh();
        TargetBean bean = (TargetBean) ctx.getBean("bean1");
        IsModified mod = (IsModified) bean;

        System.out.println("Is TargetBean&?: "+(bean instanceof  TargetBean));
        System.out.println("Is IsModified?: "+(bean instanceof IsModified));
        System.out.println("Has been modified?: "+
                mod.isModified());

        System.out.println("proxy.setName(\"Sergay Chabanov\")");
        bean.setName("Sergay Chabanov");
        System.out.println("Has been modified?: "+
                mod.isModified());
        System.out.println(" proxy.setName(\"Chris Schaefer\")");

        bean.setName("Chris Schaefer");
        System.out.println("Has been modified?: "+
                mod.isModified());

        System.out.println(" proxy.setName(\"Chris Schaefer\")");

        bean.setName("Chris Schaefer");
        System.out.println("Has been modified?: "+
                mod.isModified());
    }
}
