package com.stcodesapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Desktop implements Computer {

    public Desktop() {
        System.out.println("Creating desktop object");
    }

    @Override
    public void compile() {
        System.out.println("Compiling using desktop");
    }
}
