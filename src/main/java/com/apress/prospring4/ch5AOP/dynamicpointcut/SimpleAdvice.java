package com.apress.prospring4.ch5AOP.dynamicpointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking "+methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();

        System.out.println(">>Done");
        return  retVal;
    }
}
