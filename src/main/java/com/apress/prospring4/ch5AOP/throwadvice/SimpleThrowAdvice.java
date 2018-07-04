package com.apress.prospring4.ch5AOP.throwadvice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowAdvice implements ThrowsAdvice {
    public static void main(String[] args) throws Exception{
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(errorBean);
        factory.addAdvice(new SimpleThrowAdvice());

        ErrorBean proxy =(ErrorBean) factory.getProxy();
        try{
            proxy.errorProneMethod();
        }catch (Exception ignored){

        }
        try{
            proxy.otherErrorProneMethod();
        }catch (Exception ignored){

        }
    }
  public void afterThrowing( Exception ex) throws Throwable{
      System.out.println("****");
      System. out .println ( "Generic Exception Capture");
// перехват обобщенного исключения
      System.out.println("Caught: " + ex.getClass() .getName());
// имя исключения
      System.out.println("***\n");
  }
    public void afterThrowing(Method method, Object[] args, Object target,
                              IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
// перехват исключения IllegalArgumentException
        System.out.println("Caught: " + ex.getClass().getName());
// имя исключения
        System.out.println("Method: " + method.getName()); // имя метода
        System.out.println("***\n");
    }
}
