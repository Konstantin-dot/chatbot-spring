package com.example.chatbot;

import com.example.chatbot.service.MessageService;
import com.example.chatbot.service.MessageServiceImpl;
import com.example.chatbot.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableCaching  // включаем кэширование
public class ChatbotSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ChatbotSpringApplication.class, args);
    }
}
