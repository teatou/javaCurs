package com.example.kr1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MachineManagerApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MachineManagerApp.class, args);
    }
}
