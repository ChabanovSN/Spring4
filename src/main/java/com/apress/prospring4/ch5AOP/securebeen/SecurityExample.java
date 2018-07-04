package com.apress.prospring4.ch5AOP.securebeen;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
  private static   SecurityManager  mgr = new SecurityManager();
    public static void main(String[] args) {

        SecureBean bean =  getSecureBean();


        mgr.login("Sergay", "pwd");
        bean.writeSecureBean();
        mgr.logout();
        try{
            mgr.login("invaliduser","pwd");
            bean.writeSecureBean();
        }catch (SecurityException e){
            System.out.println("Exception Caught: "+e.getMessage());
        }finally {
            mgr.logout();
        }
        try{
            bean.writeSecureBean();
        }catch (SecurityException e){
            System.out.println("Exception Caught: "+e.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice(mgr);
        ProxyFactory factory = new ProxyFactory();

        factory.addAdvice(advice);
        factory.setTarget(target);
        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}
