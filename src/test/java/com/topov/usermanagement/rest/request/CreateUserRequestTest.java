package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.User;
import com.topov.usermanagement.service.PasswordEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {
    private final PasswordEncoder encoder = new PasswordEncoder();
    @Test
    public void mustBeCorrectBirthDate() {
        CreateUserRequest request = new CreateUserRequest(
                "vlad",
                "topov",
                "vladlogin",
                "password",
                "123",
                new BirthDateDto("22", "1", "2001"),
                new AddressDto("Ukraine", "Odessa", "som", "55")
        );
        User userEntity = request.getUserEntity(encoder);
        assertNotNull(userEntity.getBirthDate());
        assertEquals("2001-01-22", userEntity.getBirthDate().toString());
    }

}