package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MinimalSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinimalSpringBootApplication.class, args);
        System.out.println("visit http://127.0.0.1:8080/ in your browser");
    }
}
