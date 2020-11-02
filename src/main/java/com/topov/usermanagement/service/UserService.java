package com.topov.usermanagement.service;

import com.topov.usermanagement.rest.request.CreateUserRequest;

public interface UserService {
    void createUser(CreateUserRequest createUserRequest);
}
