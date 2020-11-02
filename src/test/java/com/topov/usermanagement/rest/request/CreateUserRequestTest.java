package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {
    @Test
    public void mustBeCorrectBirthDate() {
        CreateUserRequest request = new CreateUserRequest("vlad",
                "topov",
                22,
                1,
                2001,
                "vladlogin",
                "password",
                "123",
                "Ukraine",
                "Odessa",
                "som",
                4);
        User userEntity = request.getUserEntity();
        assertNotNull(userEntity.getBirthDate());
        assertEquals("2001-01-22", userEntity.getBirthDate().toString());
    }

}