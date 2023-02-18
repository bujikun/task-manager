package com.bujikun.taskmanager.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                               .usernameParameter("username")
                               .passwordParameter("password")
                               .isCustomLoginPage()
                       )
               .logout(l->l.logoutUrl("/logout")
                       .logoutSuccessUrl("/login")
                       .invalidateHttpSession(true)
                       .clearAuthentication(true)
                       .permitAll()
                       )
               .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        var user = User.withUsername("admin")
                .password("password")
                .passwordEncoder(p-> passwordEncoder().encode(p))
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
