package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
    @Override
    public String getMessage() {
        return "I am the hockey coach. Play hockey then";
    }
}
