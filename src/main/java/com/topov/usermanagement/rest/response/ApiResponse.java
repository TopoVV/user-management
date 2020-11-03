package com.topov.usermanagement.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Common response object for all rest operations in the application. Needed to provide descriptive and flexible response
 * bodies for each request.
 */

@Getter
public class ApiResponse {
    private final String message;

    public ApiResponse(String message) {
        this.message = message;
    }
}
