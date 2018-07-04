package com.apress.prospring4.ch3.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Publisher implements ApplicationContextAware {
    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context =applicationContext;
    }
    public void publish(String message){
        context.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springChp3/app-context-listener.xml");
        Publisher publisher = ctx.getBean("publisher",Publisher.class);
      //  publisher.publish("Fuck");
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           while (true) {
               String str = reader.readLine();
               publisher.publish(str);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
