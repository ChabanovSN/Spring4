package com.apress.prospring4.ch5AOP.dynamicpointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPoincut extends DynamicMethodMatcherPointcut {

   //// Dynamic check
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("Dynamic check for"+method.getName());
        int x = ((Integer)objects[0]).intValue();
        return (x !=100);
    }
//// static check
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for "+method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> (aClass == SampleBean.class);
    }
}
