package com.bujikun.taskmanager.repository;

import com.bujikun.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    Optional<Task> findTaskBySlug(UUID slug);
}
