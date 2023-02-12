package com.bujikun.taskmanager.controller;

import com.bujikun.taskmanager.service.contract.service.implementation.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    public String getAll(Model page){
        page.addAttribute("tasks",taskService.findAll());
        return "task/index";
    }
}
