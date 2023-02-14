package com.bujikun.taskmanager.repository;

import com.bujikun.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Newton Bujiku
 * @since 2023
 */
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
