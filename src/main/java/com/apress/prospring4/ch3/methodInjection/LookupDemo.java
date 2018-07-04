package com.apress.prospring4.ch3.methodInjection;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public final static void main(String[] args) {
        GenericApplicationContext context =   new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) context).load("classpath:springChp3/app-context-method.xml");
        context.refresh();

        DemoBean abstractBean = (DemoBean) context.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) context.getBean("standardLookupBean");
        displayInfo(abstractBean);
        displayInfo(standardBean);

    }

    private static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper Instances the Same?: "+(helper1==helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i <1000000 ; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethigHelpful();
        }
        stopWatch.stop();
        System.out.println("100_000 gets took "+ stopWatch.getTotalTimeMillis()+ " ms");
    }
}
