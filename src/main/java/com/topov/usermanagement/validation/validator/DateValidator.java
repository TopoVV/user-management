package com.topov.usermanagement.validation.validator;

import com.topov.usermanagement.rest.request.BirthDate;
import com.topov.usermanagement.rest.request.CreateUserRequest;
import com.topov.usermanagement.validation.constraint.ValidDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, BirthDate> {
    @Override
    public boolean isValid(BirthDate birthDate, ConstraintValidatorContext ctx) {
        int day;
        int month;
        int year;
        try {
            day = Integer.parseInt(birthDate.getBirthDay());
        } catch (NumberFormatException e) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The day field must contain only numbers")
                    .addPropertyNode("birthYear")
                    .addConstraintViolation();
            return false;
        }
        try {
            month = Integer.parseInt(birthDate.getBirthMonth());
        } catch (NumberFormatException e) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The month field must contain only numbers")
                    .addPropertyNode("birthMonth")
                    .addConstraintViolation();
            return false;
        }

        try {
            year = Integer.parseInt(birthDate.getBirthYear());
        } catch (NumberFormatException e) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The year field must contain only numbers")
            .addPropertyNode("birthDay")
            .addConstraintViolation();
            return false;
        }

        boolean valid = true;

        if (year < 1920 || year > 2020) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The year must be between 1920 and 2020")
                    .addPropertyNode("birthYear")
                    .addConstraintViolation();
            valid = false;
        }

        if (month < 1 || month > 12) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The month must be between 1 and 12")
                    .addPropertyNode("birthMonth")
                    .addConstraintViolation();
            valid = false;
        }

        if (month != 2 && (day < 1 || day > 31)) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The day must be between 1 and 31")
                    .addPropertyNode("birthDay")
                    .addConstraintViolation();
            valid = false;

        } else if (month == 2 && (day < 1 || day > 28)) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("The day of February must be between 1 and 28")
                    .addPropertyNode("birthDay")
                    .addConstraintViolation();
            valid = false;
        }
        return valid;
    }
}
