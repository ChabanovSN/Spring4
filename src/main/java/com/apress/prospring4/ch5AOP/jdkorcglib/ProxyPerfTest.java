package com.apress.prospring4.ch5AOP.jdkorcglib;


import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {
    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(),new NoOpBeforeAdvice());
        runCglibTests(advisor,target);
        runCglibFrozenTests(advisor,target);
        runJdkTests(advisor,target);
    }

    private static void runJdkTests(Advisor advisor, SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(new Class[]{SimpleBean.class});
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        // JDK
        System.out.println("Running JDK  Tests");
        test(proxy);
    }

    private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setFrozen(true);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        // CGLIB
        System.out.println("Running CGLIB (Frozen) Tests");
        test(proxy);
    }

    private static void runCglibTests(Advisor advisor, SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        // CGLIB
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
                
    }

    private static void test(SimpleBean bean) {
        long before =0;
        long after = 0;
        //testing  advised method
        System.out.println("Testing  advised method");
        before = System.currentTimeMillis();
        for (int i = 0; i <500_000 ; i++) {
            bean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took "+(after-before)+" ms");
        //testing  unadvised method
        System.out.println("Testing  unadvised method");
        before = System.currentTimeMillis();
        for (int i = 0; i <500_000 ; i++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took "+(after-before)+" ms");
        //testing  equals method
        System.out.println("Testing  equals method");
        before = System.currentTimeMillis();
        for (int i = 0; i <500_000 ; i++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took "+(after-before)+" ms");
        //testing hashCode method
        System.out.println("Testing  hashCode method");
        before = System.currentTimeMillis();
        for (int i = 0; i <500_000 ; i++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took "+(after-before)+" ms");
///Testing Advised. getProxyTargetClass () Method
        Advised advised = (Advised) bean;
        System.out.println("Testing Advised. getProxyTargetClass () Method");
        before = System.currentTimeMillis();
        for (int i = 0; i <500_000 ; i++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took "+(after-before)+" ms");
        System.out.println(">>>\n");
    }
}
