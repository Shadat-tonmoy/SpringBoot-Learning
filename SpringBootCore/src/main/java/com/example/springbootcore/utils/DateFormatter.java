package com.example.springbootcore.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateFormatter {

    public String getCurrentDate() {
        Date date = new Date();
        return date.toString();
    }

}
