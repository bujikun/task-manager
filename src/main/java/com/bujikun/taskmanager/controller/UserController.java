package com.bujikun.taskmanager.controller;

import com.bujikun.taskmanager.service.contract.IUserService;
import com.bujikun.taskmanager.service.implementation.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;
    @GetMapping("/")
    public String handleRoot(){
        return "redirect:/users";
    }
@GetMapping
    public String findAll(Model page){
        page.addAttribute("users",userService.findAll());
        return "user/index";
    }



}
