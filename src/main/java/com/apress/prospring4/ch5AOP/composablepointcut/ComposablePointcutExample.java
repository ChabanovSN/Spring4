package com.apress.prospring4.ch5AOP.composablepointcut;


import com.apress.prospring4.ch5AOP.controlflowpointcut.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class ComposablePointcutExample {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        ComposablePointcut pc =
                new ComposablePointcut(ClassFilter.TRUE,new GetterMethodMatcher());
        // test1
        System.out.println("test1");
        SampleBean proxy = getProxy(pc,target);
        testInvoke(proxy);

        // test2
        System.out.println("test2");
        pc.union(new SetterMethodMatcher());
       proxy = getProxy(pc,target);
        testInvoke(proxy);




        // test3
        System.out.println("test3");
        pc.intersection(new GetAgeMethodMatcher());
         proxy = getProxy(pc,target);
        testInvoke(proxy);
    }

    private static void testInvoke(SampleBean proxy) {
        proxy.getAge();
        proxy.getName();
        proxy.setName("Max");
    }

    private static SampleBean getProxy(ComposablePointcut pc, SampleBean target) {
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        return (SampleBean) pf.getProxy();
    }

    private static class GetterMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return (method.getName().startsWith("get"));
        }
    }

    private static class GetAgeMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "getAge".equals(method.getName());
        }
    }

    private static class SetterMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return (method.getName().startsWith("set"));
        }
    }
}
