package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getMessage() {
        return "Hello There! I teach to play cricket";

    }
}
