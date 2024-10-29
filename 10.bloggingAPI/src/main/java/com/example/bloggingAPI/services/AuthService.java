package com.example.bloggingAPI.services;

import com.example.bloggingAPI.payloads.LoginRequest;
import com.example.bloggingAPI.payloads.LoginResponse;
import com.example.bloggingAPI.payloads.UserDto;

public interface AuthService {


    UserDto signup(UserDto userDto);

    LoginResponse login(LoginRequest loginRequest) throws Exception;
}
