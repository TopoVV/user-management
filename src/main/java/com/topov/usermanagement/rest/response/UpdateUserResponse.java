package com.topov.usermanagement.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.topov.usermanagement.dto.UserDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UpdateUserResponse extends ApiResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto userDto;
    public UpdateUserResponse(HttpStatus status, String message, UserDto userDto) {
        super(status, message);
        this.userDto = userDto;
    }
}
