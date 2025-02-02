package com.stcodesapp.spring_boot_security.config;

import com.stcodesapp.spring_boot_security.services.DBUserDetailsService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTFilter jwtFilter;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // disable csrf token
        httpSecurity.csrf(customizer -> customizer.disable());

        // enabling authentication for every request
        httpSecurity.authorizeHttpRequests(customizer -> customizer
                .requestMatchers(HttpMethod.POST, "/sign-up", "/login")
                .permitAll()
                .anyRequest()
                .authenticated()
        );

        // enabling form based login
//        httpSecurity.formLogin(Customizer.withDefaults());

        // setting http basic rules to default
        httpSecurity.httpBasic(Customizer.withDefaults());

        // update session creation policy to stateless session management
        httpSecurity.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // set authentication provider like dao, ldap or okta
        httpSecurity.authenticationProvider(authenticationProvider());

        // setting user details service - commenting out as it is being set by authentication provider
        // httpSecurity.userDetailsService(userDetailsService());

        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        authProvider.setPasswordEncoder(bcryptPasswordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }


    @Bean
    public UserDetailsService userDetailsService() {

//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("shadat")
//                .password("pass1234")
//                .roles("USER")
//                .build();
//
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("shadat_admin")
//                .password("pass1234")
//                .roles("ADMIN","USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, admin);
        return new DBUserDetailsService();
    }


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
