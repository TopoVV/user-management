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
    @NotEmpty(message = "The first name field must not be empty")
    private String firstName;
    @NotEmpty(message = "The last name field must not be empty")
    private String lastName;
    @NotNull(message = "The day of birth field must not be empty")
    private Integer birthDay;
    @NotNull(message = "The month of birth field must not be empty")
    private Integer birthMonth;
    @NotNull(message = "The year of birth field must not be empty")
    private Integer birthYear;
    @NotEmpty(message = "The login field must not be empty")
    private String login;
    @NotEmpty(message = "The password field must not be empty")
    private String password;
    @NotEmpty(message = "The about field must not be empty")
    @Length(max = 100)
    private String about;
    @NotEmpty(message = "The country field must not be empty")
    private String country;
    @NotEmpty(message = "The city field must not be empty")
    private String city;
    @NotEmpty(message = "The street field must not be empty")
    private String street;
    @NotNull(message = "The house number field must not be empty")
    private Integer houseNo;


    public LocalDate getBirthDate() {
        return LocalDate.of(birthYear, birthMonth, birthDay);
    }

    public Address getAddress() {
        return new Address(country, city, street, houseNo);
    }
}
