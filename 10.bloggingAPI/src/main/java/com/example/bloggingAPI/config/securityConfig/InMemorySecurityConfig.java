package com.example.bloggingAPI.config.securityConfig;

import com.example.bloggingAPI.constans.ConstValues;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemorySecurityConfig {

    /*@Bean
    public InMemoryUserDetailsManager getUserDetailManager() {
        UserDetails user = User.builder()
                .username("tonmoy")
                .password("{noop}pass1234")
                .roles(ConstValues.ROLE_USER)
                .build();

        UserDetails user2 = User.builder()
                .username("shadat")
                .password("{noop}pass5678")
                .roles(ConstValues.ROLE_USER, ConstValues.ROLE_ADMIN)
                .build();

        UserDetails user3 = User.builder()
                .username("shadat.tonmoy")
                .password("{noop}pass9012")
                .roles(ConstValues.ROLE_USER)
                .build();

        return new InMemoryUserDetailsManager(user, user2, user3);
    }*/


    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(registry -> {
            registry.requestMatchers(HttpMethod.GET, "/api/v1/posts")
                    .hasAnyRole(ConstValues.ROLE_USER, ConstValues.ROLE_ADMIN);

            registry.requestMatchers(HttpMethod.POST,"user/{userId}/category/{categoryId}/posts")
                    .hasRole(ConstValues.ROLE_ADMIN);

        });

        security.httpBasic(Customizer.withDefaults());
        security.csrf(csrfConfigurer -> csrfConfigurer.disable());
        return security.build();
    }*/


}
