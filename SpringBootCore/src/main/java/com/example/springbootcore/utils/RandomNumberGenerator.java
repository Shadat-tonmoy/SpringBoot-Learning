package com.example.springbootcore.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator {

    public int getRandomInt() {
        return new Random().nextInt();
    }
}
