package com.topov.usermanagement.rest.response;

import org.springframework.http.HttpStatus;

public class CreateUserResponse extends ApiResponse {
    public CreateUserResponse(HttpStatus status, String message) {
        super(status, message);
    }
}
