package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Constructor call of "+getClass().getSimpleName());
    }

    @Override
    public String getMessage() {
        return "Hello There! I teach to play cricket";

    }
}
