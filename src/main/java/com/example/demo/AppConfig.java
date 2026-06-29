package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User userBean() {
        User user = new User("Mario");
        return user;
    }

    @Bean
    public User 
}
