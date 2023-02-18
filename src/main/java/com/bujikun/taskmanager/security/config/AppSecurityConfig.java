package com.bujikun.taskmanager.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Newton Bujiku
 * @since 2023
 */

@Configuration
public class AppSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity
               .authorizeHttpRequests(req->req.requestMatchers("/font/**").permitAll()
                       .requestMatchers("/webjars/**").permitAll()
                       .requestMatchers("/css/**").permitAll()
                       .requestMatchers("/js/**").permitAll()
                       .requestMatchers("/login").permitAll()
                       .requestMatchers("/img/**").permitAll()
                       .anyRequest().authenticated())
               .formLogin(f->f.loginPage("/login")
                               .failureForwardUrl("/login")
                               .defaultSuccessUrl("/")
                               .isCustomLoginPage()
                       )
               .build();
    }
}
