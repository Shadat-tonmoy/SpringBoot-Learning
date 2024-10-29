package com.example.bloggingAPI.config.securityConfig;

import com.example.bloggingAPI.entities.User;
import com.example.bloggingAPI.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class DaoSecurityConfig {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private JWTSecurityFilter jwtSecurityFilter;


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User userWithUserName = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No user found with : " + username));
            return userWithUserName;
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(requestMatcherRegistry -> {
            requestMatcherRegistry.requestMatchers(HttpMethod.POST, "auth/signup")
                    .permitAll();

            requestMatcherRegistry.requestMatchers(HttpMethod.GET, "auth/login")
                    .permitAll();

            requestMatcherRegistry.anyRequest().authenticated();

        });

        httpSecurity.csrf(csrfConfigurer -> csrfConfigurer.disable());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(sessionManagementConfigurer -> {
            sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.addFilterBefore(jwtSecurityFilter, UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();

    }

}
