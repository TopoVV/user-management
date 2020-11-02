package com.topov.usermanagement.rest.response;

import com.topov.usermanagement.dto.UserDto;
import com.topov.usermanagement.rest.response.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class GetAllUsersResponse extends ApiResponse {
    public final List<UserDto> users;

    public GetAllUsersResponse(HttpStatus status, String message, List<UserDto> users) {
        super(status, message);
        this.users = users;
    }
}
