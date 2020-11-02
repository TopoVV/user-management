package com.topov.usermanagement.service.result;

import com.topov.usermanagement.dto.UserDto;
import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.rest.response.GetAllUsersResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class GetAllUsersOperationResult extends OperationResult{
    private List<UserDto> users;

    public GetAllUsersOperationResult(String message, HttpStatus status, List<UserDto> users) {
        super(message, status);
        this.users = users;
    }

    @Override
    public ApiResponse getResponseBody() {
        return new GetAllUsersResponse(status, message, users);
    }
}
