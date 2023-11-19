package com.example.springbootcore.demo.controllers.dataProvider;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("Constructor call of " + getClass().getSimpleName());
    }


    @PostConstruct
    public void doInitialStuff() {
        System.out.println("Do initial stuff called from : "+getClass().getSimpleName());
    }


    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("Do cleanup stuff called from : "+getClass().getSimpleName());

    }

    @Override
    public String getMessage() {
        return "I am the hockey coach. Play hockey then";
    }
}
