package com.apress.prospring4.ch5AOP.afterreturnigadvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        if((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))){
            long key = ((Long) returnValue).longValue();
            if(key == KeyGenerator.WEAK_KEY){
                throw new SecurityException("Key Generator generated a weak key. Try again");
            }
        }
    }
}
