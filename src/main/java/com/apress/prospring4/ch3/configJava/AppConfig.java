package com.apress.prospring4.ch3.configJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
///@ImportResource(value = "") for XML config
@PropertySource(value = "properties/message.properties")
@ComponentScan(basePackages = {"com.apress.prospring4.ch3.configJava"})
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    @Lazy(value =true)
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }
    @Bean(name = "messageRender" )
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRender messageRender(){
        MessageRender render = new StandardOutMessageRenderer();
        render.setMessageProvider(messageProvider());
        return render;
    }

}
