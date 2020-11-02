package com.topov.usermanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Global exception informational class for any unhandled errors occurring during the execution.
 */

@Getter
@Setter
public class UserManagementException extends RuntimeException {
    private HttpStatus errorCode;
    public UserManagementException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.errorCode = status;
    }
}
