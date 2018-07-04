package com.apress.prospring4.ch5AOP.afterreturnigadvice;

import org.springframework.aop.framework.ProxyFactory;



public class AfterAdviceExample {
    private static KeyGenerator getKeyGenerator(){

        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new WeakKeyCheckAdvice());
        factory.setTarget(target);
        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String[] args) {
       KeyGenerator keyGen = getKeyGenerator();
        for (int i = 0; i <10 ; i++) {
            try{
                long key = keyGen.getKey();
                System.out.println("Key: "+key);
            }catch (SecurityException e){
                System.out.println(" Weak Key Generated");
            }
        }
    }
}
