package com.bujikun.taskmanager.exception.task;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskNotFoundException extends RuntimeException{
    private String message;
}
