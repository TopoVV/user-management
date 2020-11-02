package com.topov.usermanagement.controller.advice;

import com.topov.usermanagement.exception.UserManagementException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = UserManagementException.class)
    public ResponseEntity<String> handleUserManagementException(UserManagementException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }
}
