package com.ak2.bookingcosplay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // Disable CSRF and authentication for all endpoints
    http.csrf().disable()
        .authorizeRequests()
        .anyRequest().permitAll() // Allow all requests without authentication
        .and()
        .formLogin().disable()
        .httpBasic().disable();

    return http.build();
  }
}
