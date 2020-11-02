package com.topov.usermanagement.service.result;

import com.topov.usermanagement.dto.UserDto;
import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.rest.response.GetOneUserResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GetOneUserOperationResult extends OperationResult {
    private UserDto userDto;

    public GetOneUserOperationResult(String message, HttpStatus status, UserDto userDto) {
        super(message, status);
        this.userDto = userDto;
    }

    @Override
    public ApiResponse getResponseBody() {
        return new GetOneUserResponse(status, message, userDto);
    }
}
