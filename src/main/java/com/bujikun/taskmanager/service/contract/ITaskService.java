package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;

import java.util.List;
import java.util.UUID;

public interface ITaskService {
    List<TaskDTO> findAll();
    void createTask(TaskDTO taskDTO);
    void deleteTaskBySlug(UUID slug);
    void updateTask(TaskDTO taskDTO);
    Task findTaskBySlug(UUID slug);
    Task findTaskById(Integer id);

}
