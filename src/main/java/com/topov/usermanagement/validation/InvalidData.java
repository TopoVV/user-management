package com.topov.usermanagement.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class InvalidData {
    private final String invalidProperty;
    private final String description;
}
