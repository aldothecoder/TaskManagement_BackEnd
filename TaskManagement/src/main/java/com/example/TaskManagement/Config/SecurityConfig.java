package com.example.TaskManagement.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
            .authorizeHttpRequests(authorize -> 
                authorize
                    .requestMatchers("/login", "/register", "/user/tasks/**", "/tasks/**").permitAll() // Permit these endpoints without authentication
                    .anyRequest().authenticated() // Require authentication for all other requests
            );
        return http.build();
    }
}
