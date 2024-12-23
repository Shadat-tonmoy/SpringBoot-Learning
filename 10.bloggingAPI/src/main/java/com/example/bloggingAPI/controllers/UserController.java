package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.OperationResponse;
import com.example.bloggingAPI.payloads.UserDto;
import com.example.bloggingAPI.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("user")
    public ResponseEntity<UserDto> createNewUser(@Valid @RequestBody UserDto userDto) {
//        System.out.println("Will create a new user as : " + userDto);
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("users")
    public List<UserDto> getAllUser() {
        System.out.println("Get all user called");
        return userService.getAllUsers();
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int userId) throws ResourceNotFoundException {
        System.out.println("get user with id : " + userId);
        UserDto userWithId = userService.getUserById(userId);
        return new ResponseEntity<>(userWithId, HttpStatus.OK);
    }

    @PutMapping("user/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int userId) throws ResourceNotFoundException {
        System.out.println("Update user with id : " + userId);
        UserDto updatedUserDto = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<OperationResponse> deleteUser(@PathVariable int userId) throws ResourceNotFoundException {
        System.out.println("Delete user with id : " + userId);
        userService.deleteUser(userId);
        OperationResponse response = new OperationResponse(true, "User is deleted successfully!");
        return ResponseEntity.ok(response);
    }

    @GetMapping("user")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam(name = "email") String email) throws ResourceNotFoundException {
        System.out.println("getUserByEmail : " + email);
        UserDto userDto = userService.getUserByEmail(email);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
