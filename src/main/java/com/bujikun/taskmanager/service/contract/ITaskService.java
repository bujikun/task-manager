package com.bujikun.taskmanager.service.contract;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * @author Newton Bujiku
 * @since 2023
 */
public interface ITaskService {
    List<TaskDTO> findAll();
    List<TaskDTO> findAllByUser(Authentication authentication);

    void createTask(TaskDTO taskDTO);

    void deleteTask(String id);

    void updateTask(String id, TaskDTO taskDTO);

    Task findTaskById(String id);

}
