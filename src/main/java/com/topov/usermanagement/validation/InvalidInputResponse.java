package com.topov.usermanagement.validation;

import com.topov.usermanagement.rest.response.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class InvalidInputResponse extends ApiResponse {
    private final List<InvalidData> invalidityList = new ArrayList<>();

    public InvalidInputResponse(BindingResult bindingResult) {
        super("Invalid input");
        bindingResult.getFieldErrors().forEach(fieldError -> {
            invalidityList.add(new InvalidData(fieldError.getField(), fieldError.getDefaultMessage()));
        });
    }

    public InvalidInputResponse(Set<ConstraintViolation<UserUpdateValidation>> violations) {
        super("Invalid input");
        violations.forEach(violation -> {
            String property = violation.getMessageTemplate();
            String message = violation.getMessage();
            invalidityList.add(new InvalidData(property, message));
        });
    }
}
