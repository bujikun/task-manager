package com.bujikun.taskmanager.exception.user;

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
public class UserNotFoundException extends RuntimeException{
    private String message;
}
