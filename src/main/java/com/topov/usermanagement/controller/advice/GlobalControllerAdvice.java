package com.topov.usermanagement.controller.advice;

import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.validation.InvalidInputResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = UserManagementException.class)
    public ResponseEntity<String> handleUserManagementException(UserManagementException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidInputResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(new InvalidInputResponse(e.getBindingResult(), "Invalid input"));
    }
}
