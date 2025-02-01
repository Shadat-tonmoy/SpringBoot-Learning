package com.stcodesapp.spring_boot_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/greet")
    public String greet(HttpServletRequest request){
        return "Hello World "+request.getSession().getId();
    }


    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "About "+request.getSession().getId();
    }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Welcome to Spring Boot Security. Your session id is : "+request.getSession().getId();


    }
}
