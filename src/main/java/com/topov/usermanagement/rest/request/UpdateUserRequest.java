package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.validation.constraint.ValidDate;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
public class UpdateUserRequest {
    @NotEmpty(message = "The first name field must not be empty")
    private String firstName;
    @NotEmpty(message = "The last name field must not be empty")
    private String lastName;
    @NotEmpty(message = "The login field must not be empty")
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

    public BirthDateDto getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address.getAddressModel();
    }
}
