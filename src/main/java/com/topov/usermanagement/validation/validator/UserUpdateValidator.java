package com.topov.usermanagement.validation.validator;

import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.model.User;
import com.topov.usermanagement.repository.UserRepository;
import com.topov.usermanagement.validation.UserUpdateValidation;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserUpdateValidator implements ConstraintValidator<UniqueLogin, UserUpdateValidation> {
    private UserRepository userRepository;

    @Override
    public boolean isValid(UserUpdateValidation userUpdateValidation, ConstraintValidatorContext ctx) {
        User user = userRepository.findById(userUpdateValidation.getUserId())
                .orElseThrow(() -> new UserManagementException("User not found", null, HttpStatus.NOT_FOUND));

        String login = userUpdateValidation.getLogin();

        if (!user.getLogin().equals(login) && userRepository.existsByLogin(login)) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("Login")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
