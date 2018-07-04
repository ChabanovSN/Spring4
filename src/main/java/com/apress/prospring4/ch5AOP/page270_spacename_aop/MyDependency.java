package com.apress.prospring4.ch5AOP.page270_spacename_aop;

public class MyDependency {
    public void foo(int intValue){
        System.out.println("foo(int): "+intValue);
    }
    public void bar(){
        System.out.println("bar()");
    }

}
