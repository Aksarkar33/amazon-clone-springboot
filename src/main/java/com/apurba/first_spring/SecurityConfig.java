package com.apurba.first_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Allow POST requests for now
            .authorizeHttpRequests(auth -> auth
                // 1. Allow EVERYONE to see the home page and static files
                .requestMatchers("/", "/index.html", "/style.css", "/script.js").permitAll()
                
                // 2. Allow EVERYONE to see the list of products (API)
                .requestMatchers(HttpMethod.GET, "/product").permitAll()
                .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
                
                // 3. LOCK everything else (Adding/Deleting needs login)
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()); // Use the popup login

        return http.build();
    }
}
