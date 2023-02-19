package com.bujikun.taskmanager.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Controller
@RequestMapping("/")
public class AccountController {
    @GetMapping
    public String getRoot(){
        return "redirect:/tasks";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "account/login";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session, HttpServletResponse response){
        session.invalidate();
        SecurityContextHolder.getContext().setAuthentication(null);
        response.addCookie(new Cookie("JSESSIONID",";"));
        return "redirect:/login";
    }
}
