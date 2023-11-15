package com.example.springbootcore.demo.controllers;

import com.example.springbootcore.demo.controllers.dataProvider.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Coach coach;

    @Autowired
    public TestController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello";
    }

    @GetMapping("/coach-message")
    public String getCoachMessage() {
        return coach.getMessage();
    }

}
