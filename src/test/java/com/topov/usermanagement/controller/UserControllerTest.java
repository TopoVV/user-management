package com.topov.usermanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topov.usermanagement.repository.UserRepository;
import com.topov.usermanagement.rest.request.AddressDto;
import com.topov.usermanagement.rest.request.BirthDateDto;
import com.topov.usermanagement.rest.request.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @MockBean
    private UserRepository userRepository;
    private MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void whenLoginExists_ThenMustReturnBadRequest() throws Exception {
        CreateUserRequest request = new CreateUserRequest(
                "vlad",
                "topov",
                "vladlogin",
                "password",
                "123",
                new BirthDateDto("22", "1", "2001"),
                new AddressDto("Ukraine", "Odessa", "som", "55")
        );
        String json = objectMapper.writeValueAsString(request);

        when(userRepository.existsByLogin(request.getLogin())).thenReturn(true);

        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
        .andDo(print())
        .andExpect(status().isBadRequest());
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}