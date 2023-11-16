package com.example.springbootcore.demo.controllers;

import com.example.springbootcore.demo.controllers.dataProvider.Coach;
import com.example.springbootcore.utils.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootcore.utils.DateFormatter;

@RestController
public class TestController {

    private final Coach coach;
    private final DateFormatter dateFormatter;

    private RandomNumberGenerator randomNumberGenerator;

    @Autowired
    public TestController(@Qualifier("hockeyCoach")  Coach coach, DateFormatter dateFormatter) {
        this.coach = coach;
        this.dateFormatter = dateFormatter;
    }

    @Autowired
    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello. Now is " + dateFormatter.getCurrentDate()+" And a random number is : "+randomNumberGenerator.getRandomInt();
    }

    @GetMapping("/coach-message")
    public String getCoachMessage() {
        return coach.getMessage();
    }

}
