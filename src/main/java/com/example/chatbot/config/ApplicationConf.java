package com.example.chatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConf {

    @Bean
    public Object bean() {
        return new Object();
    }
}
