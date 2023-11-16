package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("Constructor call of "+getClass().getSimpleName());
    }

    @Override
    public String getMessage() {
        return "I am the hockey coach. Play hockey then";
    }
}
