package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<Task> findAll();
    Task createTask(TaskDTO taskDTO);
    void deleteTask(TaskDTO taskDTO);
    Task updateTask(TaskDTO taskDTO);
    Optional<Task> findTaskBySlug(TaskDTO taskDTO);
    Optional<Task> findTaskById(TaskDTO taskDTO);
    void updateTaskStatus(TaskDTO taskDTO);

}