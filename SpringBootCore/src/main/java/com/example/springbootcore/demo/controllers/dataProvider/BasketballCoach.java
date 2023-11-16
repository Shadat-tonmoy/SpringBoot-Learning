package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
    @Override
    public String getMessage() {
        return "Hello This is a BasketBallCoach. Play BasketBall";
    }
}
