package com.apress.prospring4.ch5AOP.page276_using_annotation_aspectj;


import com.apress.prospring4.ch5AOP.page270_spacename_aop.MyDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    private MyDependency1 myDependency;
    public void execute(){
        myDependency.foo(100);
        myDependency.foo(101);
        myDependency.bar();
    }

@Autowired
 public void setMyDependency(MyDependency1 myDependency) {
        this.myDependency = myDependency;
    }


}
