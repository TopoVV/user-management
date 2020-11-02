package com.topov.usermanagement.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse {
    @JsonIgnore
    private HttpStatus status;
    private final String message;

    public ApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
