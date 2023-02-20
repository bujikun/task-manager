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

import java.util.Arrays;

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
    public String getLogin(Model page) {
        final var failed = false;
        page.addAttribute("failed",failed);
        return "account/login";
    }

    @GetMapping("/invalid-login")
    public String handleLoginError(Model page) {
        final var failed = true;
        page.addAttribute("failed",failed);
        return "account/login";
        //throw new RuntimeException();
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
