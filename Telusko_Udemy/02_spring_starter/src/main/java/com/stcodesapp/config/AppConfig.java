package com.stcodesapp.config;

import com.stcodesapp.Alien;
import com.stcodesapp.Computer;
import com.stcodesapp.Desktop;
import com.stcodesapp.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "desktop")
    @Scope(scopeName = "prototype")
    @Primary
    public Desktop desktop() {
        return new Desktop();
    }

    @Bean
    public Laptop laptop() {
        return new Laptop();
    }

    @Bean
    public Alien getAlien(Computer computer) {
        Alien alien = new Alien();
        alien.setAge(45);
        alien.setComputer(computer);
        return alien;
    }
}
