package com.topov.usermanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserManagementException extends RuntimeException {
    private HttpStatus errorCode;
    public UserManagementException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.errorCode = status;
    }
}
