package com.topov.usermanagement.validation.validator;

import com.topov.usermanagement.rest.request.BirthDateDto;
import com.topov.usermanagement.validation.constraint.ValidDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DateValidatorTest {
    private final Validator validator;

    @Autowired
    DateValidatorTest(Validator validator) {
        this.validator = validator;
    }

    @Test
    void whenMonthFebruaryAndDayGreaterThen30_ThenFalse() {
        BirthDateDto birthDateDto = new BirthDateDto("30", "2", "2001");
        Set<ConstraintViolation<Wrapper>> violations = validator.validate(new Wrapper(birthDateDto));
        assertTrue(violations.size() > 0);
        assertEquals(1, violations.size());
    }

    @Test
    void whenNotMonthFebruaryAndDayGreaterThen30_ThenFalse() {
        BirthDateDto birthDateDto = new BirthDateDto("30", "3", "2001");
        Set<ConstraintViolation<Wrapper>> violations = validator.validate(new Wrapper(birthDateDto));
        assertEquals(0, violations.size());
    }

    private static final class Wrapper {
        @ValidDate
        private final BirthDateDto birthDateDto;

        public Wrapper(BirthDateDto birthDateDto) {
            this.birthDateDto = birthDateDto;
        }
    }
}