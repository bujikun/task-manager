package com.bujikun.taskmanager.security.config;

import com.bujikun.taskmanager.security.service.SecurityUserDetailService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Newton Bujiku
 * @since 2023
 */

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig {
   // private final HttpSession session;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(req -> req.requestMatchers("/font/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .invalidSessionUrl("/login").sessionFixation(sf->sf.migrateSession())
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false)
                        .expiredUrl("/login")
                )
                .formLogin(f -> f.loginPage("/login")
                        .defaultSuccessUrl("/")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .failureUrl("/login?error=true")
                        .isCustomLoginPage()
                )
                .logout()
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/login")
                //.addLogoutHandler(logoutHandler(session))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .and()
                .build();
    }

//    @Bean
//    public LogoutHandler logoutHandler(HttpSession session){
//        return (request,response,authentication)->{
//            session.invalidate();
//            //authentication.setAuthenticated(false);
//            SecurityContextHolder.getContext().setAuthentication(null);
//            Arrays.stream(request.getCookies())
//                            .map(c->{
//                                c.setValue(null);
//                                return c;
//                            }).forEach(c->response.addCookie(c));
//            try {
//                response.sendRedirect("/login");
//                throw new RuntimeException();
//
//            } catch (IOException e) {
//            }
//            // response.addCookie(new Cookie("JSESSIONID",";"));
//        };
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

 //   @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        var user = User.withUsername("admin")
//                .password("password")
//                .passwordEncoder(p -> passwordEncoder().encode(p))
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        //for handling session fixation
        return new HttpSessionEventPublisher();
    }
}
