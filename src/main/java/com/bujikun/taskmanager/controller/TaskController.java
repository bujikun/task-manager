package com.bujikun.taskmanager.controller;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.service.implementation.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    @PostMapping( "/add")
    public String createNewTask(@ModelAttribute TaskDTO taskDTO, Model page){
        //do validation
        taskService.createTask(taskDTO);
        page.addAttribute("tasks",taskService.findAll());
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String getTaskToEdit(@PathVariable UUID id, Model page){
        var task = taskService.findTaskById(id);
        page.addAttribute("taskdto",task);
        return "task/edit";
    }
    @PostMapping("/edit/{slug}")
    public String editTask(@ModelAttribute TaskDTO taskDTO, @PathVariable("slug")UUID slug, Model page){
        //do validation
        taskDTO.setId(slug);
        taskService.updateTask(taskDTO);
        page.addAttribute("tasks",taskService.findAll());
        return "redirect:/tasks";
    }

}
