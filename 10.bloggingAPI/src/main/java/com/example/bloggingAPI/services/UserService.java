package com.example.bloggingAPI.services;

import com.example.bloggingAPI.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, int userId);

    UserDto getUserById(int userId);

    List<UserDto> getAllUsers();

    void deleteUser(int userId);
}
