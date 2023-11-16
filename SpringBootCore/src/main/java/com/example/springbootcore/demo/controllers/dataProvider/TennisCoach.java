package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getMessage() {
        return "I am the Tennis Coach. Play tennis";
    }
}
