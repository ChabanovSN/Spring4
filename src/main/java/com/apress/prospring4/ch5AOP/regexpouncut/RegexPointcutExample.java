package com.apress.prospring4.ch5AOP.regexpouncut;

import com.apress.prospring4.ch5AOP.dynamicpointcut.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexPointcutExample {
    public static void main(String[] args) {
        RegexBean target = new RegexBean();
        JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
        pc.setPattern(".*foo.*");
        Advisor advisor = new DefaultPointcutAdvisor( pc, new SimpleAdvice());
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(target);

        RegexBean proxy = (RegexBean) factory.getProxy();

        proxy.foo1();
        proxy.foo2();
        proxy.bar();

    }
}
