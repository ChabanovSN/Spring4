package com.apress.prospring4.ch5AOP.beforeadvice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);
        MessageWriter messageWriter =(MessageWriter) pf.getProxy();
        messageWriter.writeMessage();

    }


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method:" + method.getName());
    }
}
