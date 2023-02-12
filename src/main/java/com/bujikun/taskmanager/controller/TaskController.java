package com.bujikun.taskmanager.controller;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.service.contract.service.implementation.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public String getTaskAdditionForm(Model page){
        page.addAttribute("taskdto",new TaskDTO());
        return "/task/add";
    }
    @PostMapping(value = "/add")
    public String createNewTask(@ModelAttribute TaskDTO taskDTO, Model page){
        //do validation
        taskService.createTask(taskDTO);
        page.addAttribute("tasks",taskService.findAll());
        return "task/index";
    }



}
