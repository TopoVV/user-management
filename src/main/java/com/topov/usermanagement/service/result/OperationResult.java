package com.topov.usermanagement.service.result;

import com.topov.usermanagement.rest.response.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Service logic execution result container.
 */

@Getter
public abstract class OperationResult {
    protected String message;
    protected HttpStatus status;

    protected OperationResult(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public abstract ApiResponse getResponseBody();
}
