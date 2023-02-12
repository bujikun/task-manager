package com.bujikun.taskmanager.service.implementation;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<TaskDTO> findAll() {
        return taskRepository.findAll(Sort.by(Sort.Direction.DESC,"createdOn")).stream()
                .map(t-> TaskDTO.builder()
                        .title(t.getTitle())
                        .description(t.getDescription())
                        .status(t.getStatus())
                        .slug(t.getSlug())
                        .createdOn(Util.formatDateTime(t.getCreatedOn()))
                        .updatedOn(Util.formatDateTime(t.getUpdatedOn()))
                        .build())
                .collect(Collectors.toList());
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
    public void deleteTaskBySlug(UUID slug) {
        //check if task exist to find to report error when findBySlug throws exception
        var task = taskRepository.findTaskBySlug(slug);
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
    public Task findTaskBySlug(UUID slug) {
        return taskRepository.findTaskBySlug(slug)
                .orElseThrow(()->new TaskNotFoundException("Task with slug:  "+slug +" " +
                        "could no t be found!"));
    }

    @Override
    public Task findTaskById(Integer slug) {
        return null;
    }

}
