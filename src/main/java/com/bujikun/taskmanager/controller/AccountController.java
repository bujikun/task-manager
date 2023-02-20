package com.bujikun.taskmanager.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Controller
@RequestMapping("/")
public class AccountController {
    @GetMapping
    public String getRoot() {
        return "redirect:/tasks";
    }
    @GetMapping("/login")
    public String handleLoginError(Model page, @RequestParam(required = false) String error) {
        if(Optional.ofNullable(error).isPresent() && error.equals("true")){
            page.addAttribute("failed",true);
        }else{
            page.addAttribute("failed",false);
        }
        return "account/login";
    }
    @GetMapping("/logout")
    public String doLogout(HttpSession session, HttpServletResponse response,
                           HttpServletRequest request, Authentication authentication) {
        authentication.setAuthenticated(false);
        session.invalidate();
        SecurityContextHolder.getContext().setAuthentication(null);
        Arrays.stream(request.getCookies())
                .map(c -> {
                    c.setValue(null);
                    return c;
                }).forEach(c -> response.addCookie(c));
        return "redirect:/login";
    }
}
