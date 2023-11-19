package com.example.springbootcore.demo.controllers.dataProvider;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("Constructor call of " + getClass().getSimpleName());
    }

    @Override
    public String getMessage() {
        return "I am the hockey coach. Play hockey then";
    }
}
