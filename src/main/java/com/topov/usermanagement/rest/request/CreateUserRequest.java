package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;
import com.topov.usermanagement.service.PasswordEncoder;
import com.topov.usermanagement.validation.constraint.UniqueLogin;
import com.topov.usermanagement.validation.constraint.ValidDate;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
    @NotEmpty(message = "The login field must not be empty")
    @UniqueLogin
    private String login;
    @NotEmpty(message = "The password field must not be empty")
    private String password;
    @NotEmpty(message = "The about field must not be empty")
    @Length(max = 100)
    private String about;
    @ValidDate
    private BirthDateDto birthDate;
    @Valid
    private AddressDto address;

    public User getUserEntity(PasswordEncoder encoder) {
        try {
            Address addressModel = address.getAddressModel();
            String encodedPassword = encoder.encodePassword(password);

            return new User( firstName, lastName, birthDate.getDate(), login, encodedPassword, about, addressModel);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.error("Error during extraction the User entity from CreateUserRequest", e);
            throw new UserManagementException("Cannot create user", e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
