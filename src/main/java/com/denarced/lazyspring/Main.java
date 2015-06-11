package com.denarced.lazyspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> myMap = new HashMap<>();
        myMap.put(AppConfig.MESSAGE_KEY, "myValue");
        propertySources.addFirst(new MapPropertySource("MY_MAP", myMap));
        context.setEnvironment(environment);
        context.refresh();

        MessageService messageService = context.getBean(MessageService.class);
        System.out.println("The message: " + messageService.message());
    }
}