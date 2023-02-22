package com.bujikun.taskmanager.repository;

import com.bujikun.taskmanager.dto.TaskDTO;
import com.bujikun.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * @author Newton Bujiku
 * @since 2023
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("select t from Task t where t.user.id =:id")
    List<Task> findAllTasksByUserId(Integer id);
}
