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
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsManager getJDBCUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id = ?");

        return userDetailsManager;
    }

    /*@Bean
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


    }*/


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
