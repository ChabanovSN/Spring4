package com.apress.prospring4.ch5AOP.page270_spacename_aop;



public class MyBean {
    private MyDependency dep;
    public void execute(){
        dep.foo(100);
        dep.foo(101);
        dep.bar();
    }
    public void setDep(MyDependency dep){
        this.dep=dep;
    }
}