package com.apress.prospring4.ch5AOP.page265_proxyfactorybean;

public class MyBean {
    private MyDependency dep;
    public void execute(){
        dep.foo();
        dep.bar();
    }
    public void setDep(MyDependency dep){
        this.dep=dep;
    }
}
