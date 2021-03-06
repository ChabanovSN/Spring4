package com.apress.prospring4.ch5AOP.dynamicpointcut;


import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutExample {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPoincut(),new com.apress.prospring4.ch5AOP.dynamicpointcut.SimpleAdvice());
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        SampleBean proxy =(SampleBean) factory.getProxy();
        proxy.foo(1);
        proxy.foo(10);
        proxy.foo(100);
        proxy.bar();
        proxy.bar();
        proxy.bar();


    }
}
