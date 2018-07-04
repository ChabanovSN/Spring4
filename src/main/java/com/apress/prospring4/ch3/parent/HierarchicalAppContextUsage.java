package com.apress.prospring4.ch3.parent;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

    public static void main(String[] args) {
        GenericApplicationContext parent =   new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) parent).load("classpath:springChp3/app-context-parent.xml");
        parent.refresh();

        GenericApplicationContext child =
                new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) child).load("classpath:springChp3/app-context-child.xml");
       child.setParent(parent);
        child.refresh();

        SimpleTarget target1 = child.getBean("target1", SimpleTarget.class);
        SimpleTarget target2 = child.getBean("target2", SimpleTarget.class);
        SimpleTarget target3 = child.getBean("target3", SimpleTarget.class);

        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());

    }
}
