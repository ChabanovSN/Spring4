package com.apress.prospring4.ch5AOP.around;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {
    public static void main(String[] args) {
        WorkerBean bean = getWorkinBean();
        bean.doSomeWork(1000000);
    }

    private static WorkerBean getWorkinBean() {
        WorkerBean bean = new WorkerBean();
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new ProfilingInterceptor());
        factory.setTarget(bean);
      return  (WorkerBean) factory.getProxy();

    }
}
