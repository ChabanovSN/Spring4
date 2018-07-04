package com.apress.prospring4.ch5AOP.securebeen;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
UserINfo user = securityManager.getLoggedOnUser();
if(user == null){
    System.out.println("No user authenticated");
    throw new SecurityException("You must login before" +
            " attempting to invoke method: "+ method.getName());
}else if ("sergay".equalsIgnoreCase(user.getUserName())){
    System.out.println("logged in user is Sergay - OKAY! ");

}else {
    System.out.println("LOgged in user is "+ user.getUserName()+
    " NOT GOOD :(" );
    throw new SecurityException("User "+ user.getUserName()+
    " is not allowed access to method "+method.getName());
}
    }
}
