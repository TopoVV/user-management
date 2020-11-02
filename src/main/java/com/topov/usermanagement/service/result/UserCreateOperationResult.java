package com.topov.usermanagement.service.result;

import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.rest.response.CreateUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserCreateOperationResult extends OperationResult {
    public UserCreateOperationResult(String message, HttpStatus status) {
        super(message, status);
    }

    @Override
    public ApiResponse getResponseBody() {
        return new CreateUserResponse(status, message);
    }
}
