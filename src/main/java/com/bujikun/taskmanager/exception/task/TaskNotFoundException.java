package com.bujikun.taskmanager.exception.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Newton Bujiku
 * @since 2023
 */
@AllArgsConstructor
@Getter
@Setter
public class TaskNotFoundException extends RuntimeException {
    private String message;
}
