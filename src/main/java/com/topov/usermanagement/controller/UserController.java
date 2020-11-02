package com.topov.usermanagement.controller;

import com.topov.usermanagement.rest.request.CreateUserRequest;
import com.topov.usermanagement.rest.request.UpdateUserRequest;
import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.rest.response.CreateUserResponse;
import com.topov.usermanagement.rest.response.UpdateUserResponse;
import com.topov.usermanagement.service.UserService;
import com.topov.usermanagement.service.result.UserCreateOperationResult;
import com.topov.usermanagement.service.result.UserUpdateOperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserCreateOperationResult result = userService.createUser(createUserRequest);
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest,
                                                         @PathVariable Long userId) {
        UserUpdateOperationResult result = userService.updateUser(updateUserRequest, userId);
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }
}
