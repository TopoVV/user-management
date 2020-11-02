package com.topov.usermanagement.rest.response;

import org.springframework.http.HttpStatus;

public class DeleteUserResponse extends ApiResponse {
    public DeleteUserResponse(HttpStatus status, String message) {
        super(status, message);
    }
}
