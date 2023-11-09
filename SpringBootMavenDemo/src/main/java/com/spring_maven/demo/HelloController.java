package com.spring_maven.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/")
    public String sayHello() {
        return "<h2>Hello World</h2>";
    }


    @GetMapping("/workout")
    public String getWorkout() {
        return "<h3>Workout List</h3>";
    }


}
