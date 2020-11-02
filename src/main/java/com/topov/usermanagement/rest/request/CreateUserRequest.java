package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private int birthDay;
    private int birthMont;
    private int birthYear;
    private String login;
    private String password;
    private String about;
    private String country;
    private String city;
    private String street;
    private int houseNo;

    public User getUserEntity() {
        Address address = new Address(country, city, street, houseNo);
        return new User(firstName, lastName, LocalDate.of(birthYear, birthMont, birthDay), login, password, about, address);
    }
}
