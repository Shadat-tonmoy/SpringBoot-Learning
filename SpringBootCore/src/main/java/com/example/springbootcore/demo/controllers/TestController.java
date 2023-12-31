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
    private final Coach anotherCoach;
    private final DateFormatter dateFormatter;

    private Coach swimmingCoach;

    private RandomNumberGenerator randomNumberGenerator;

    @Autowired
    public TestController(@Qualifier("hockeyCoach") Coach coach, @Qualifier("hockeyCoach") Coach anotherCoach, DateFormatter dateFormatter) {
        this.coach = coach;
        this.anotherCoach = anotherCoach;
        this.dateFormatter = dateFormatter;
    }

    @Autowired
    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Autowired
    public void setSwimCoach(@Qualifier("swimCoach") Coach swimCoach) {
        this.swimmingCoach = swimCoach;
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello. Now is " + dateFormatter.getCurrentDate() + " And a random number is : " + randomNumberGenerator.getRandomInt();
    }

    @GetMapping("/coach-message")
    public String getCoachMessage() {
        return coach.getMessage();
    }


    @GetMapping("/check")
    public String check() {
        String message = "The two coach are the same object : " + (coach == anotherCoach);
        return message;
    }

    @GetMapping("/swim-coach")
    public String getSwimCoachMessage() {
        return swimmingCoach.getMessage();
    }

}
