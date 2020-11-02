package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotNull
    private Integer birthDay;
    @NotNull
    private Integer birthMonth;
    @NotNull
    private Integer birthYear;
    @NotEmpty
    @UniqueLogin
    private String login;
    @NotEmpty
    private String password;
    @NotEmpty
    @Length(max = 100)
    private String about;
    @NotEmpty
    private String country;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotNull
    private Integer houseNo;

    public User getUserEntity() {
        Address address = new Address(country, city, street, houseNo);
        return new User(firstName, lastName, LocalDate.of(birthYear, birthMonth, birthDay), login, password, about, address);
    }
}
