package com.topov.usermanagement.validation.constraint;

import com.topov.usermanagement.validation.validator.DateValidator;
import com.topov.usermanagement.validation.validator.UniqueLoginConstraintValidator;
import com.topov.usermanagement.validation.validator.UserUpdateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = { DateValidator.class }
)
public @interface ValidDate {
    String message() default "Invalid date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
