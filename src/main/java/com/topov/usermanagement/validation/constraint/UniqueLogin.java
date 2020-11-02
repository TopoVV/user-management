package com.topov.usermanagement.validation.constraint;

import com.topov.usermanagement.validation.validator.UniqueLoginConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = { UniqueLoginConstraintValidator.class }
)
public @interface UniqueLogin {
    String message() default "This login is already in use";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
