package com.bujikun.taskmanager.exception.user.advice;

import com.bujikun.taskmanager.exception.user.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Newton Bujiku
 * @since 2023
 */

@ControllerAdvice
public class UserExceptionControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    public void userNotFound() {

    }
}
