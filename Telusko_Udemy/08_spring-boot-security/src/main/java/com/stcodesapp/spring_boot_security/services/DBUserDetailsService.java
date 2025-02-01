package com.stcodesapp.spring_boot_security.services;

import com.stcodesapp.spring_boot_security.models.UserPrincipal;
import com.stcodesapp.spring_boot_security.models.Users;
import com.stcodesapp.spring_boot_security.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DBUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);
        if(user == null){
            System.out.println("User not found with user name : "+username);
            throw new UsernameNotFoundException("User not found with user name : "+username);
        }
        return new UserPrincipal(user);
    }
}
