package com.apress.prospring4.ch5AOP.page281_singl_aspectj;

public class MessageWriter {
    public void writeMessage(){
        System.out.println("foobar!");
    }
    public void foo(){
        System.out.println("foo");
    }
}
