package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.payloads.LoginRequest;
import com.example.bloggingAPI.payloads.LoginResponse;
import com.example.bloggingAPI.payloads.SignupResponse;
import com.example.bloggingAPI.payloads.UserDto;
import com.example.bloggingAPI.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("signup")
    public ResponseEntity<SignupResponse> signup(@Valid @RequestBody UserDto userDto) {
        UserDto signedUpUser = authService.signup(userDto);
        SignupResponse response = new SignupResponse(signedUpUser.getId(), signedUpUser.getFirstName(), signedUpUser.getLastName(), signedUpUser.getEmail());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
        LoginResponse loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }


}
