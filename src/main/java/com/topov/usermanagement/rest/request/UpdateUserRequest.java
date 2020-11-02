package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private Integer birthDay;
    private Integer birthMonth;
    private Integer birthYear;
    private String login;
    private String password;
    private String about;
    private String country;
    private String city;
    private String street;
    private Integer houseNo;

    public LocalDate getBirthDate() {
        return LocalDate.of(birthYear, birthMonth, birthDay);
    }

    public Address getAddress() {
        return new Address(country, city, street, houseNo);
    }
}
