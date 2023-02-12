package com.bujikun.taskmanager;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;
import com.bujikun.taskmanager.repository.TaskRepository;
import com.bujikun.taskmanager.service.contract.service.implementation.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

}
