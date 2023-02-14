package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;

import java.util.List;
import java.util.UUID;

public interface ITaskService {
    List<TaskDTO> findAll();
    void createTask(TaskDTO taskDTO);
    void deleteTask(UUID id);
    void updateTask(TaskDTO taskDTO);
    Task findTaskById(UUID slug);

}
