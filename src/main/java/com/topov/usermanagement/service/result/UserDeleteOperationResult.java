package com.topov.usermanagement.service.result;

import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.rest.response.DeleteUserResponse;
import org.springframework.http.HttpStatus;

public class UserDeleteOperationResult extends OperationResult {
    public UserDeleteOperationResult(String message, HttpStatus status) {
        super(message, status);
    }

    @Override
    public ApiResponse getResponseBody() {
        return new DeleteUserResponse(message);
    }
}
