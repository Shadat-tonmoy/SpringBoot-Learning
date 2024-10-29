package com.example.bloggingAPI.services;

import com.example.bloggingAPI.entities.User;
import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.LoginRequest;
import com.example.bloggingAPI.payloads.LoginResponse;
import com.example.bloggingAPI.payloads.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto signup(UserDto userDto) {
        try {
            UserDto userWithUserName = userService.getUserByEmail(userDto.getEmail());
            return userWithUserName;
        } catch (ResourceNotFoundException exception) {
            exception.printStackTrace();
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserDto createdUser = userService.createUser(userDto);
        return createdUser;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws ResourceNotFoundException {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        UserDto userDto = userService.getUserByEmail(loginRequest.getUserName());
        User user = modelMapper.map(userDto, User.class);
        String accessToken = jwtService.generateToken(new HashMap<>(), user);
        long expiresIn = jwtService.getExpireTime(accessToken);
        return new LoginResponse(accessToken, accessToken, expiresIn);
    }
}
