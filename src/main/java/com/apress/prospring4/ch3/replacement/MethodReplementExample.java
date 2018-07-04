package com.apress.prospring4.ch3.replacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext();
        context.load("springChp3/app-context-replacement.xml");
        context.refresh();
        ReplacmentTarget replacmentTarget = (ReplacmentTarget) context.getBean("replacementTarget",ReplacmentTarget.class);
        ReplacmentTarget standardtTarget = (ReplacmentTarget) context.getBean("standardTarget",ReplacmentTarget.class);

        displayInfo(replacmentTarget);
        displayInfo(standardtTarget);
    }

    private static void displayInfo(ReplacmentTarget target) {
        System.out.println(target.formatMessage("Hello World"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int i = 0; i <100000 ; i++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();
        System.out.println("100_000 invocations took: " +stopWatch.getTotalTimeMillis()+ " ms");
    }
}
