package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import com.topov.usermanagement.validation.constraint.ValidDate;
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
    @ValidDate
    private BirthDate birthDate;
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


    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return new Address(country, city, street, houseNo);
    }
}
