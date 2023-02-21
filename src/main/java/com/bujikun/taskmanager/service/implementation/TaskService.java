package com.bujikun.taskmanager.service.implementation;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;
import com.bujikun.taskmanager.enumeration.Priority;
import com.bujikun.taskmanager.enumeration.Status;
import com.bujikun.taskmanager.exception.task.TaskNotFoundException;
import com.bujikun.taskmanager.repository.TaskRepository;
import com.bujikun.taskmanager.service.contract.ITaskService;
import com.bujikun.taskmanager.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private Function<Task, TaskDTO> convertTaskToDTO =
            (t) -> TaskDTO.builder()
                    .title(t.getTitle())
                    .description(t.getDescription())
                    .status(t.getStatus().getValue())
                    .priority(t.getPriority().getValue())
                    .id(t.getId())
                    .createdOn(Util.formatDateTime(t.getCreatedOn()))
                    .updatedOn(Util.formatDateTime(t.getUpdatedOn()))
                    .build();

    @Override
    public List<TaskDTO> findAll() {
        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createdOn")).stream()
                .map(convertTaskToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        var task = Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .status(Status.valueOf(taskDTO.getStatus()))
                .priority(Priority.valueOf(taskDTO.getPriority()))
                .build();
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(String id) {
//check if task exist to find to report error when findBySlug throws exception
        var task = findTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    public void updateTask(String id, TaskDTO taskDTO) {
        //find the task to be updated first
        var task = findTaskById(id);
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(Status.valueOf(taskDTO.getStatus()));
        task.setPriority(Priority.valueOf(taskDTO.getPriority()));
        //insert into db
        taskRepository.save(task);
    }

    @Override
    public Task findTaskById(String id) {
        Integer uuid;
        try {
            uuid =Integer.valueOf(id);

        } catch (IllegalArgumentException e) {
            throw new TaskNotFoundException("Task with slug:  " + id + " " +
                    "could no t be found!");
        }
        return taskRepository.findById(uuid)
                .orElseThrow(() -> new TaskNotFoundException("Task with slug:  " + id + " " +
                        "could no t be found!"));
    }

}
