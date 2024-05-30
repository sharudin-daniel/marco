package com.example.marco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarcoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarcoApplication.class, args);
    }

}
