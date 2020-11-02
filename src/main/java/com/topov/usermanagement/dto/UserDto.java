package com.topov.usermanagement.dto;

import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;

import javax.persistence.*;
import java.time.LocalDate;

public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String login;
    private String about;
    private Address address;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.login = user.getLogin();
        this.about = user.getAbout();
        this.address = user.getAddress();
    }
}
