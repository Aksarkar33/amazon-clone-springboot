package com.apurba.first_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Apurba! Your First Spring Boot Server is RUNNING! 🚀";
    }
}