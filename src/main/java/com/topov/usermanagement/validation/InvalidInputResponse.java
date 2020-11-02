package com.topov.usermanagement.validation;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InvalidInputResponse {
    private final String message;
    private final List<InvalidData> invalidityList = new ArrayList<>();

    public InvalidInputResponse(BindingResult bindingResult, String message) {
        this.message = message;
        bindingResult.getFieldErrors().forEach(fieldError -> {
            invalidityList.add(new InvalidData(fieldError.getField().toString(), fieldError.getDefaultMessage()));
        });
    }
}
