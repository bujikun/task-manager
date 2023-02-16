package com.bujikun.taskmanager.controller;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.enumeration.Status;
import com.bujikun.taskmanager.service.contract.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final ITaskService taskService;


    @GetMapping("/")
    public String getAllRedirect() {
        return "redirect:/tasks";
    }

    @GetMapping
    public String getAll(Model page) {
        var allTasks = taskService.findAll();
        var completed = allTasks.stream()
                .filter(t -> t.getStatus().equals(Status.COMPLETED.getValue()))
                .count();
        var inProgress = allTasks.stream()
                .filter(t -> t.getStatus().equals(Status.IN_PROGRESS.getValue()))
                .count();
        var notStarted = allTasks.stream()
                .filter(t -> t.getStatus().equals(Status.NOT_STARTED.getValue()))
                .count();

        page.addAttribute("tasks", allTasks);
        page.addAttribute("completed", completed);
        page.addAttribute("inProgress", inProgress);
        page.addAttribute("notStarted", notStarted);
        return "task/index";
    }

    @GetMapping("/add")
    public String getTaskAdditionForm(Model page) {
        page.addAttribute("taskdto", new TaskDTO());
        return "/task/add";
    }

    @PostMapping("/add")
    public String createNewTask(@ModelAttribute TaskDTO taskDTO, Model page) {
        //do validation
        taskService.createTask(taskDTO);
        page.addAttribute("tasks", taskService.findAll());
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String getTaskToEdit(@PathVariable String id, Model page) {
        var task = taskService.findTaskById(id);
        page.addAttribute("taskdto", task);
        return "task/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@ModelAttribute TaskDTO taskDTO, @PathVariable("id") String id, Model page) {
        //do validation
        taskService.updateTask(id, taskDTO);
        page.addAttribute("tasks", taskService.findAll());
        return "redirect:/tasks";
    }

}
