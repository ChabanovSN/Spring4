package com.apress.prospring4.ch3.list;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericApplicationContext parent =   new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) parent).load("classpath:springChp3/app-context-list.xml");
        parent.refresh();

        CollectionInjection instance = parent.getBean("injectCollection",CollectionInjection.class);
        instance.displayInfo();
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
    public void displayInfo(){
        com.apress.prospring4.ch3.annotation.CollectionInjection.namee(map, props, set, list);
    }
}
