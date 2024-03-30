package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach {

    public BasketballCoach() {
        System.out.println("Constructor call of " + getClass().getSimpleName());
    }

    @Override
    public String getMessage() {
        return "Hello This is a BasketBallCoach. Play BasketBall";
    }
}
