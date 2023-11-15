package com.example.springbootcore.demo.controllers;

import com.example.springbootcore.demo.controllers.dataProvider.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootcore.utils.DateFormatter;

@RestController
public class TestController {

    private final Coach coach;
    private final DateFormatter dateFormatter;

    @Autowired
    public TestController(Coach coach, DateFormatter dateFormatter) {
        this.coach = coach;
        this.dateFormatter = dateFormatter;
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello. Now is "+dateFormatter.getCurrentDate();
    }

    @GetMapping("/coach-message")
    public String getCoachMessage() {
        return coach.getMessage();
    }

}
