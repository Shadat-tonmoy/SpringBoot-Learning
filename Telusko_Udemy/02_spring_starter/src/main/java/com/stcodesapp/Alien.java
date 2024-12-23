package com.stcodesapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("45")
    private int age;

    @Autowired
    @Qualifier("desktop")
    private Computer computer;

    public Alien() {
        System.out.println("Alien object created!");
    }

    public Alien(int age) {
        this.age = age;
        System.out.println("Parameterized constructor called");
    }

    public Alien(int age, Computer computer) {
        this.age = age;
        this.computer = computer;
        System.out.println("Double parameterized constructor called");
    }

    public void code(){
        computer.compile();
        System.out.println("Coding... with "+this.hashCode());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setting age as "+age+" to alien : "+this.hashCode());
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Alien "+this.hashCode()+" age is : "+age);
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        System.out.println("Setting computer instance "+computer.hashCode()+" to alien : "+this.hashCode());
        this.computer = computer;
    }
}
