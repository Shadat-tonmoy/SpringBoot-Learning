package com.example.springSecurityDemo.config;

import com.example.springSecurityDemo.constants.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(requestMatcherRegistry -> {
            requestMatcherRegistry
                    .requestMatchers(HttpMethod.GET, "/api/v1/employee")
                    .hasAnyRole(Roles.EMPLOYEE.name(), Roles.MANAGER.name(), Roles.ADMIN.name())

                    .requestMatchers(HttpMethod.GET, "/api/v1/employee/**")
                    .hasAnyRole(Roles.EMPLOYEE.name(), Roles.MANAGER.name(), Roles.ADMIN.name())

                    .requestMatchers(HttpMethod.POST, "/api/v1/employee")
                    .hasRole(Roles.MANAGER.name())

                    .requestMatchers(HttpMethod.PUT, "/api/v1/employee")
                    .hasRole(Roles.MANAGER.name())

                    .requestMatchers(HttpMethod.DELETE, "/api/v1/employee/**")
                    .hasRole(Roles.ADMIN.name());
        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrfConfigurer -> csrfConfigurer.disable());

        return httpSecurity.build();
    }
}
