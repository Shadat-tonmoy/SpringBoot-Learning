package com.example.bloggingAPI.services;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, int userId) throws ResourceNotFoundException;

    UserDto getUserById(int userId) throws ResourceNotFoundException;

    List<UserDto> getAllUsers();

    void deleteUser(int userId) throws ResourceNotFoundException;

    UserDto getUserByEmail(String email) throws ResourceNotFoundException;
}
