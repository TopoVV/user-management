package com.topov.usermanagement.validation;

import com.topov.usermanagement.rest.request.UpdateUserRequest;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import lombok.Getter;

/**
 * Special class for proper validation of User modification request. Needed to avoid the situation when application
 * would reject the update if the login remains unchanged.
 */

@Getter
@UniqueLogin
public class UserUpdateValidation {
    private final Long userId;
    private final String login;

    public UserUpdateValidation(UpdateUserRequest updateUserRequest, Long userId) {
        this.login = updateUserRequest.getLogin();
        this.userId = userId;
    }
}
