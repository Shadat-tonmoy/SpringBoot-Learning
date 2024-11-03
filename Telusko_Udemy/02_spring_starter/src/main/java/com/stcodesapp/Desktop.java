package com.stcodesapp;

public class Desktop implements Computer {

    public Desktop() {
        System.out.println("Creating desktop object");
    }

    @Override
    public void compile() {
        System.out.println("Compiling using desktop");
    }
}
