package com.apress.prospring4.ch5AOP.dynamicpointcut;

public class SampleBean {
    public void foo(int x){
        System.out.println("Invoked foo() with: "+x);
    }
    public void bar(){
        System.out.println("Invoked bar()");
    }
}
