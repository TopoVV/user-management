package com.topov.usermanagement.controller;

import com.topov.usermanagement.rest.request.CreateUserRequest;
import com.topov.usermanagement.rest.request.UpdateUserRequest;
import com.topov.usermanagement.rest.response.ApiResponse;
import com.topov.usermanagement.service.UserService;
import com.topov.usermanagement.service.result.*;
import com.topov.usermanagement.validation.InvalidInputResponse;
import com.topov.usermanagement.validation.UserUpdateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final Validator validator;

    @Autowired
    public UserController(UserService userService, Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listAllUsers() {
        GetAllUsersOperationResult result = userService.getAllUsers();
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getOneUser(@PathVariable Long userId) {
        GetOneUserOperationResult result = userService.getUserById(userId);
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserCreateOperationResult result = userService.createUser(createUserRequest);
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest,
                                                  @PathVariable Long userId) {

        Set<ConstraintViolation<UserUpdateValidation>> violations =
                validator.validate(new UserUpdateValidation(updateUserRequest, userId));

        if (!violations.isEmpty()) {
            InvalidInputResponse response = new InvalidInputResponse(violations);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        UserUpdateOperationResult result = userService.updateUser(updateUserRequest, userId);
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        UserDeleteOperationResult result = userService.deleteUser(userId);
        return ResponseEntity.status(result.getStatus()).body(result.getResponseBody());
    }
}
