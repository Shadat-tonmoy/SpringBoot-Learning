package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("Constructor call of "+getClass().getSimpleName());
    }

    @Override
    public String getMessage() {
        return "I am the Tennis Coach. Play tennis";
    }
}
