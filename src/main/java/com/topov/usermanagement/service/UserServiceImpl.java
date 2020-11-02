package com.topov.usermanagement.service;

import com.topov.usermanagement.UserRepository;
import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.model.User;
import com.topov.usermanagement.rest.request.CreateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void createUser(CreateUserRequest createUserRequest) {
        try {
            User user = createUserRequest.getUserEntity();
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            log.error("Conflict during user creation");
            throw new UserManagementException("Conflict during user creation. Try again later", e, HttpStatus.CONFLICT);
        }
    }
}
