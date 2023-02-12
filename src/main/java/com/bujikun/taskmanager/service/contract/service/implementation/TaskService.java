package com.bujikun.taskmanager.service.contract.service.implementation;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;
import com.bujikun.taskmanager.exception.task.TaskNotFoundException;
import com.bujikun.taskmanager.repository.TaskRepository;
import com.bujikun.taskmanager.service.contract.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        var task = Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .slug(UUID.randomUUID())
                .build();
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(TaskDTO taskDTO) {
        //check if task exist to find to report error when findBySlug throws exception
        var task = taskRepository.findTaskBySlug(taskDTO.getSlug());
         taskRepository.deleteTaskBySlug(task.get().getSlug());
    }

    @Override
    public Task updateTask(TaskDTO taskDTO) {
        //find the task to be updated first
        var task = taskRepository.findTaskBySlug(taskDTO.getSlug()).get();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        //insert into db
        return taskRepository.save(task);
    }

    @Override
    public Task findTaskBySlug(TaskDTO taskDTO) {
        return taskRepository.findTaskBySlug(taskDTO.getSlug())
                .orElseThrow(()->new TaskNotFoundException("Task with slug:  "+taskDTO.getSlug() +" " +
                        "could no t be found!"));
    }

    @Override
    public Task findTaskById(TaskDTO taskDTO) {
        return null;
    }
    
}
