package com.example.springbootjpa.JPADemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test() {
        return "Your Spring Boot App is up and running!";
    }
}
