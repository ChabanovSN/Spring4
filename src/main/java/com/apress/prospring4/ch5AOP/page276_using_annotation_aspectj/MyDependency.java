package com.apress.prospring4.ch5AOP.page276_using_annotation_aspectj;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("myDependency")
 class MyDependency1  {
    public void foo(int intValue){
        System.out.println("foo(int): "+intValue);
    }
    public void bar(){
        System.out.println("bar()");
    }

}
