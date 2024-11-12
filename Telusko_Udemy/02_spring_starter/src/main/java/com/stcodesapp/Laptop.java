package com.stcodesapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer {

    public Laptop() {
        System.out.println("Laptop object created!");
    }

    @Override
    public void compile(){
        System.out.println("Compiling... through laptop");
    }
}
