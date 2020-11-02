package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;
import com.topov.usermanagement.service.PasswordEncoder;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Arrays;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class CreateUserRequest {
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
    @UniqueLogin
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

    public User getUserEntity(PasswordEncoder encoder) {
        try {
            Address address = new Address(country, city, street, houseNo);
            String encodedPassword = encoder.encodePassword(password);
            return new User(
                    firstName,
                    lastName,
                    LocalDate.of(birthYear, birthMonth, birthDay),
                    login,
                    encodedPassword.toString(),
                    about,
                    address
            );

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.error("Error during extraction the User entity from CreateUserRequest", e);
            throw new UserManagementException("Cannot create user", e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
