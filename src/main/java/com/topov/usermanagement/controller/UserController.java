package com.topov.usermanagement.controller;

import com.topov.usermanagement.rest.request.CreateUserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public String createUser(@RequestBody CreateUserRequest createUserRequest) {
        System.out.println(createUserRequest);
        return "hello";
    }
}
