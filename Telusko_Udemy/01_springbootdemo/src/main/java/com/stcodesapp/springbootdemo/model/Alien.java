package com.stcodesapp.springbootdemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    @Qualifier("desktop")
    private Computer computer;

    public void code() {
        computer.compile();
        System.out.println("Coding");
    }
}
