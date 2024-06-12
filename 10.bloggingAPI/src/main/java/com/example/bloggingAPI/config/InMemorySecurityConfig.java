package com.example.bloggingAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemorySecurityConfig {

    @Bean
    public InMemoryUserDetailsManager getUserDetailManager() {
        UserDetails user = User.builder()
                .username("tonmoy")
                .password("{noop}pass1234")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("shadat")
                .password("{noop}pass5678")
                .roles("USER","ADMIN")
                .build();

        UserDetails user3 = User.builder()
                .username("shadat.tonmoy")
                .password("{noop}pass9012")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user, user2, user3);





    }


}
