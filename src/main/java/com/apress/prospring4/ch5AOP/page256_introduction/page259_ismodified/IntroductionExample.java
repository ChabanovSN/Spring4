package com.apress.prospring4.ch5AOP.page256_introduction.page259_ismodified;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionExample {
    public static void main(String[] args) {
        TargetBean target = new TargetBean();
       target.setName("Sergay Chabanov");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);/// CGLIB

        TargetBean proxy = (TargetBean) pf.getProxy();
        IsModified proxyInterface = (IsModified)proxy;
        System.out.println("Is TargetBean&?: "+(proxy instanceof  TargetBean));
        System.out.println("Is IsModified?: "+(proxy instanceof IsModified));
        System.out.println("Has been modified?: "+
        proxyInterface.isModified());

        System.out.println("proxy.setName(\"Sergay Chabanov\")");
        proxy.setName("Sergay Chabanov");
        System.out.println("Has been modified?: "+
                proxyInterface.isModified());
        System.out.println(" proxy.setName(\"Chris Schaefer\")");

        proxy.setName("Chris Schaefer");
        System.out.println("Has been modified?: "+
                proxyInterface.isModified());

        System.out.println(" proxy.setName(\"Chris Schaefer\")");

        proxy.setName("Chris Schaefer");
        System.out.println("Has been modified?: "+
                proxyInterface.isModified());

    }
}
