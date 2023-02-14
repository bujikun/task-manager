package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;

import java.util.List;

/**
 * @author Newton Bujiku
 * @since 2023
 */
public interface ITaskService {
    List<TaskDTO> findAll();

    void createTask(TaskDTO taskDTO);

    void deleteTask(String id);

    void updateTask(String id, TaskDTO taskDTO);

    Task findTaskById(String id);

}
