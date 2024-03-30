package com.example.springbootSecurityFull.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public UserDetailsManager inMemoryUserDetailsManager() {

        UserDetails testStudent = User.withUsername("test-student")
                .password("pass1234")
                .roles(Roles.STUDENT.name())
                .build();

        UserDetails testAdmin = User.withUsername("test-admin")
                .password("pass1234")
                .roles(Roles.ADMIN.name())
                .build();

        UserDetails testInstructor = User.withUsername("test-instructor")
                .password("pass1234")
                .roles(Roles.INSTRUCTOR.name())
                .build();

        return new InMemoryUserDetailsManager(testStudent, testInstructor, testAdmin);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(requestMatcherRegistry -> {
            requestMatcherRegistry.requestMatchers("api/v1/students")
                    .hasRole(Roles.STUDENT.name());

        });

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrfConfigurer -> csrfConfigurer.disable());

        return httpSecurity.build();


    }

}
