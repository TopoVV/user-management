package com.topov.usermanagement.service.result;

import com.topov.usermanagement.dto.UserDto;
import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.rest.response.UpdateUserResponse;
import org.springframework.http.HttpStatus;

public class UserUpdateOperationResult extends OperationResult {
    private UserDto userDto;

    public UserUpdateOperationResult(String message, HttpStatus status, UserDto userDto) {
        super(message, status);
        this.userDto = userDto;
    }

    @Override
    public ApiResponse getResponseBody() {
        return new UpdateUserResponse(message, userDto);
    }
}
