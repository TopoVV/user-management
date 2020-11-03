package com.topov.usermanagement.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.topov.usermanagement.dto.UserDto;
import com.topov.usermanagement.rest.response.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GetOneUserResponse extends ApiResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto user;
    public GetOneUserResponse(String message, UserDto user) {
        super(message);
        this.user = user;
    }

}
