package com.apress.prospring4.ch5AOP.namedmatchpointcut;

import com.apress.prospring4.ch5AOP.dynamicpointcut.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointcutExample {
    public static void main(String[] args) {
        NameBean target = new NameBean();
        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("foo");
        pc.addMethodName("bar");
        Advisor advisor = new DefaultPointcutAdvisor(pc,new SimpleAdvice());
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
