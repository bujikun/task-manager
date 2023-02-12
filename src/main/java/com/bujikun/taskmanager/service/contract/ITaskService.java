package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;

import java.util.List;

public interface ITaskService {
    List<Task> findAll();
    Task createTask(TaskDTO taskDTO);
    void deleteTask(TaskDTO taskDTO);
    Task updateTask(TaskDTO taskDTO);
    Task findTaskBySlug(TaskDTO taskDTO);
    Task findTaskById(TaskDTO taskDTO);

}
