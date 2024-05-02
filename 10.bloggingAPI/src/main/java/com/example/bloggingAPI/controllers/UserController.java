package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.payloads.UserDto;
import com.example.bloggingAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("user")
    public UserDto createNewUser(@RequestBody UserDto userDto) {
        System.out.println("Will create a new user as : " + userDto);
        return null;


    }
}
