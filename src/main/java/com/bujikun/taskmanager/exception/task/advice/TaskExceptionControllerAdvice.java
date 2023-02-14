package com.bujikun.taskmanager.exception.task.advice;

import com.bujikun.taskmanager.exception.task.TaskNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskExceptionControllerAdvice {
    @ExceptionHandler(TaskNotFoundException.class)
    public String taskNotFound(TaskNotFoundException e){
        return "error";
    }
}
