package com.topov.usermanagement.validation.validator;

import com.topov.usermanagement.repository.UserRepository;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLoginConstraintValidator implements ConstraintValidator<UniqueLogin, String> {
    private UserRepository userRepository;

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByLogin(login);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
