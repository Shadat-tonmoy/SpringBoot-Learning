package com.example.bloggingAPI.services;

import com.example.bloggingAPI.entities.User;
import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.UserDto;
import com.example.bloggingAPI.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepo.save(user);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) throws ResourceNotFoundException {
        User userWithId = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId + ""));
        User updatedUser = modelMapper.map(userDto, User.class);
        updatedUser.setId(userId);
        User savedUser = userRepo.save(updatedUser);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        savedUserDto.setId(userId);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(int userId) throws ResourceNotFoundException {
        User userById = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId + ""));
        UserDto userDto = modelMapper.map(userById, UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUser = userRepo.findAll();
        List<UserDto> allUserDto = allUser.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return allUserDto;
    }

    @Override
    public void deleteUser(int userId) throws ResourceNotFoundException {
        User userWithId = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId + ""));
        userRepo.delete(userWithId);

    }

    @Override
    public UserDto getUserByEmail(String email) throws ResourceNotFoundException {
        User userWithEmail = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        UserDto userDtoWithEmail = modelMapper.map(userWithEmail, UserDto.class);
        return userDtoWithEmail;
    }
}
