package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {
    @Autowired
   @Qualifier("map")
    private Map<String, Object> map;
    @Autowired
    @Qualifier("propss")
  //  @Resource(name ="propss")
    private Properties props;
    @Autowired
    @Resource(name ="set")
    private Set set;
    @Autowired
    @Resource(name ="list")
    private List list;

    public static void main(String[] args) {
        GenericApplicationContext parent =   new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) parent).load("classpath:springChp3/app-context-annotation.xml");
        parent.refresh();

        CollectionInjection instance = (CollectionInjection) parent.getBean("injectCollection");
        instance.displayInfo();
    }

    public void displayInfo(){
        namee(map, props, set, list);
    }

    public static void namee(Map<String, Object> mapi, Properties props, Set set, List list) {
        System.out.println("Map contents:\n");
        for(Map.Entry<String, Object> entry : mapi.entrySet()){
            System.out.println("Key: "+ entry.getKey()+ " - Value: "+
            entry.getValue());
        }
        System.out.println("\nProperties contents:\n");
        for(Map.Entry<Object, Object> entry : props.entrySet()){
            System.out.println("Key: "+ entry.getKey()+ " - Value: "+
                    entry.getValue());
        }
        System.out.println("\nSet contents:\n");
        for(Object obj : set) System.out.println("Value: "+obj);
        System.out.println("\nList contents:\n");
        for(Object obj : list) System.out.println("Value: "+obj);
    }
}
