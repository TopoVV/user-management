package com.topov.usermanagement.service;

import com.topov.usermanagement.dto.UserDto;
import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;
import com.topov.usermanagement.repository.UserRepository;
import com.topov.usermanagement.rest.request.CreateUserRequest;
import com.topov.usermanagement.rest.request.UpdateUserRequest;
import com.topov.usermanagement.service.result.UserCreateOperationResult;
import com.topov.usermanagement.service.result.UserUpdateOperationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder = new PasswordEncoder();
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserCreateOperationResult createUser(CreateUserRequest createUserRequest) {
        try {
            User user = createUserRequest.getUserEntity(encoder);
            userRepository.save(user);
            return new UserCreateOperationResult("The user has been created.", HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            log.error("Some conflict occurred during user creation", e);
            throw new UserManagementException("Some conflict occurred during user creation. Try again later", e, HttpStatus.CONFLICT);
        }
    }

    @Override
    @Transactional
    public UserUpdateOperationResult updateUser(UpdateUserRequest updateUserRequest, Long userId) {
        return userRepository.findById(userId)
            .map(user -> {
                try {
                    user.setFirstName(updateUserRequest.getFirstName());
                    user.setLastName(updateUserRequest.getLastName());
                    user.setBirthDate(updateUserRequest.getBirthDate());
                    user.setLogin(updateUserRequest.getLogin());

                    String encodedPassword = encoder.encodePassword(updateUserRequest.getPassword());
                    user.setPassword(encodedPassword);

                    user.setAbout(updateUserRequest.getAbout());
                    user.setAddress(updateUserRequest.getAddress());
                    return user;
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                    log.error("Some conflict occurred during user edition", e);
                    throw new UserManagementException("Some conflict occurred during user edition. Try again later", e, HttpStatus.CONFLICT);
                }
            })
            .map(UserDto::new)
            .map(userDto -> new UserUpdateOperationResult("The user has been edited", HttpStatus.OK, userDto))
            .orElse(new UserUpdateOperationResult("User not found", HttpStatus.NOT_FOUND, null));
    }
}
