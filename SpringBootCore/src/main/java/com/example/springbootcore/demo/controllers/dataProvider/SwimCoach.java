package com.example.springbootcore.demo.controllers.dataProvider;

public class SwimCoach implements Coach {
    @Override
    public String getMessage() {
        return "Swimming is a very important exercise";
    }
}
