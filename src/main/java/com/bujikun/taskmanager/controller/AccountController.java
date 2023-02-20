package com.bujikun.taskmanager.controller;

import com.bujikun.taskmanager.dto.UserDTO;
import com.bujikun.taskmanager.service.implementation.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AccountController {
    private final UserService userService;
    @GetMapping
    public String getRoot() {
        return "redirect:/tasks";
    }

    @GetMapping("/login")
    public String handleLoginError(Model page, @RequestParam(required = false) String error) {
        if (Optional.ofNullable(error).isPresent() && error.equals("true")) {
            page.addAttribute("failed", true);
        } else {
            page.addAttribute("failed", false);
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

    @GetMapping("/register")
    public String getRegisterForm(Model page) {
        page.addAttribute("user",new UserDTO());
        return "account/register";
    }
    @PostMapping("/register")
    public String doRegister(Model page, @ModelAttribute UserDTO userDTO) {
        userService.createUser(userDTO);
        page.addAttribute("user",new UserDTO());
        return "redirect:/";
    }
}
