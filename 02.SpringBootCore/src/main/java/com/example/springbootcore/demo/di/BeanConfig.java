package com.example.springbootcore.demo.di;

import com.example.springbootcore.demo.controllers.dataProvider.Coach;
import com.example.springbootcore.demo.controllers.dataProvider.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("swimCoach")
    public Coach getSwimCoach() {
        return new SwimCoach();
    }
}
