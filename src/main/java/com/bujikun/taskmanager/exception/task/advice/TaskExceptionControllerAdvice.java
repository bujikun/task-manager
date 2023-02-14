package com.bujikun.taskmanager.exception.task.advice;

import com.bujikun.taskmanager.exception.task.TaskNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@ControllerAdvice
public class TaskExceptionControllerAdvice {
    @ExceptionHandler(TaskNotFoundException.class)
    public void taskNotFound(TaskNotFoundException e) {
    }
}
