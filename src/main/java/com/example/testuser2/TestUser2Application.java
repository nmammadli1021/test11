package com.example.testuser2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class TestUser2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestUser2Application.class, args);
    }

}
