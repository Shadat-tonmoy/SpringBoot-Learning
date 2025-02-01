package com.stcodesapp.spring_boot_security.services;

import com.stcodesapp.spring_boot_security.models.Users;
import com.stcodesapp.spring_boot_security.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users addNewUser(Users user) throws Exception {
        Users existingUsers = userRepo.findByUserName(user.getUserName());
        if(existingUsers != null){
            throw new Exception("User Already Exists with user name : "+user.getUserName());
        } else {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            Users newUser = userRepo.save(user);
            return newUser;
        }
    }


    public String login(Users users) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(users.getUserName());
        } else {
            return "Login Failed";
        }
    }
}
