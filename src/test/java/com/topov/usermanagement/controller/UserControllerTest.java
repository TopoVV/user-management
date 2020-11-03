package com.topov.usermanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topov.usermanagement.repository.UserRepository;
import com.topov.usermanagement.rest.request.AddressDto;
import com.topov.usermanagement.rest.request.BirthDateDto;
import com.topov.usermanagement.rest.request.CreateUserRequest;
import com.topov.usermanagement.rest.request.UpdateUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    private final MockMvc mvc;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    @Sql(scripts = {"classpath:sql/delete-initial-user.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void whenCreateRequestGood_ThenCreated() throws Exception {
        CreateUserRequest request = new CreateUserRequest(
                "vlad",
                "topov",
                "vladlogin",
                "password",
                "123",
                new BirthDateDto("22", "1", "2001"),
                new AddressDto("Ukraine", "Odessa", "som", "55")
        );
        String json = mapper.writeValueAsString(request);
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andDo(print())
            .andExpect(status().isCreated());
    }

    @Test
    void whenFieldsEmpty_ThenBadRequest() throws Exception {
        CreateUserRequest request = new CreateUserRequest(
                "vlad",
                "topov",
                "vladlogin",
                "",
                "123",
                new BirthDateDto("22", "1", "2001"),
                new AddressDto("Ukraine", "Odessa", "som", "55")
        );
        String json = mapper.writeValueAsString(request);
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    @Sql(scripts = {"classpath:sql/initial-user.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:sql/delete-initial-user.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void whenLoginInUse_ThenBadRequest() throws Exception {
        CreateUserRequest request = new CreateUserRequest(
                "vlad",
                "topov",
                "vladlogin",
                "password",
                "123",
                new BirthDateDto("22", "1", "2001"),
                new AddressDto("Ukraine", "Odessa", "som", "55")
        );
        String json = mapper.writeValueAsString(request);
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    void whenUserNotFound_ThenNotFound() throws Exception {
        UpdateUserRequest request = new UpdateUserRequest(
                "vlad",
                "topov",
                "vladlogin",
                "password",
                "123",
                new BirthDateDto("22", "1", "2001"),
                new AddressDto("Ukraine", "Odessa", "som", "55")
        );
        String json = mapper.writeValueAsString(request);
        mvc.perform(put("/users/121")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = {"classpath:sql/initial-user.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:sql/delete-initial-user.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void whenUpdateRequestGood_ThenOk() throws Exception {
        UpdateUserRequest request = new UpdateUserRequest(
                "vladnew",
                "topovnew",
                "vladlogin",
                "passwordnew",
                "12345",
                new BirthDateDto("23", "2", "2002"),
                new AddressDto("Ukraine1", "Odessa1", "som1", "52")
        );
        String json = mapper.writeValueAsString(request);
        mvc.perform(put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void whenDeleteUserNotFound_ThenNotFound() throws Exception {
        mvc.perform(delete("/users/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = {"classpath:sql/initial-user.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"classpath:sql/delete-initial-user.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void whenDeleteRequestGood_ThenOl() throws Exception {
        mvc.perform(delete("/users/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}