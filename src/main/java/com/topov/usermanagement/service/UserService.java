package com.topov.usermanagement.service;

import com.topov.usermanagement.rest.request.CreateUserRequest;
import com.topov.usermanagement.rest.request.UpdateUserRequest;
import com.topov.usermanagement.service.result.UserCreateOperationResult;
import com.topov.usermanagement.service.result.UserDeleteOperationResult;
import com.topov.usermanagement.service.result.UserUpdateOperationResult;

public interface UserService {
    UserCreateOperationResult createUser(CreateUserRequest createUserRequest);
    UserUpdateOperationResult updateUser(UpdateUserRequest updateUserRequest, Long userId);
    UserDeleteOperationResult deleteUser(Long userId);
}
