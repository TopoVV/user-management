package com.topov.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String login;
    private String password;
    private String about;
    private Address address;
}
