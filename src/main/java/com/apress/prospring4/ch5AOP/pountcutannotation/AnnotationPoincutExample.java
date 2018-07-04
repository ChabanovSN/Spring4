package com.apress.prospring4.ch5AOP.pountcutannotation;

import com.apress.prospring4.ch5AOP.dynamicpointcut.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPoincutExample {
    public static void main(String[] args) {
        SampleAnnotationBean target = new SampleAnnotationBean();
        AnnotationMatchingPointcut pc =  AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(target);

        SampleAnnotationBean proxy = (SampleAnnotationBean) pf.getProxy();
        proxy.foo(100);
        proxy.bar();
    }
}
