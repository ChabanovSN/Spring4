package com.apress.prospring4.ch5AOP.namedmatchpointcut;

import com.apress.prospring4.ch5AOP.dynamicpointcut.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePoincutUsingAdvisor {
    public static void main(String[] args) {
        NameBean target = new NameBean();
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
       advisor.addMethodName("foo");
       advisor.addMethodName("bar");

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(target);

        NameBean proxy = (NameBean) factory.getProxy();
        proxy.foo();
        proxy.foo(13);
        proxy.bar();
        proxy.yup();
    }
}
