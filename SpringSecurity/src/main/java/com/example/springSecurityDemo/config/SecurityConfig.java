package com.example.springSecurityDemo.config;

import com.example.springSecurityDemo.constants.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager getInMemoryUserDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}pass1234")
                .roles(Roles.EMPLOYEE.name())
                .build();

        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}pass1234")
                .roles(Roles.EMPLOYEE.name(), Roles.MANAGER.name())
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}pass1234")
                .roles(Roles.EMPLOYEE.name(), Roles.MANAGER.name(), Roles.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(john, marry, susan);


    }
}
