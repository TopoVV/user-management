package com.topov.usermanagement.validation;

import com.topov.usermanagement.rest.request.UpdateUserRequest;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import lombok.Getter;

@Getter
@UniqueLogin
public class UserUpdateValidation {
    private Long userId;
    private String login;

    public UserUpdateValidation(UpdateUserRequest updateUserRequest, Long userId) {
        this.login = updateUserRequest.getLogin();
        this.userId = userId;
    }
}
