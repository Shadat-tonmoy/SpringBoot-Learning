package com.stcodesapp.spring_boot_security.controller;

import com.stcodesapp.spring_boot_security.models.Users;
import com.stcodesapp.spring_boot_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public Users addNewUser(@RequestBody Users users) throws Exception{
        return userService.addNewUser(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users) throws Exception {
        return userService.login(users);
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }




}
