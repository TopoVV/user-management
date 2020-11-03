package com.topov.usermanagement.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.topov.usermanagement.dto.UserDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UpdateUserResponse extends ApiResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto userDto;
    public UpdateUserResponse(String message, UserDto userDto) {
        super(message);
        this.userDto = userDto;
    }
}
