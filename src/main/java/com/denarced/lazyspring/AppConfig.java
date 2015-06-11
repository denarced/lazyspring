package com.denarced.lazyspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
public class AppConfig {
    public static final String MESSAGE_KEY = "xyz";

    @Autowired
    private Environment environment;

    @Bean
    public String message() {
        return environment.getProperty(MESSAGE_KEY);
    }
}
