package com.topov.usermanagement.rest.request;

import com.topov.usermanagement.model.Address;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * DTO class for the address data separation in requests.
 */

@Getter
public class AddressDto {
    @NotEmpty(message = "The country field must not be empty")
    private String country;
    @NotEmpty(message = "The city field must not be empty")
    private String city;
    @NotEmpty(message = "The street field must not be empty")
    private String street;
    @NotEmpty(message = "The house number field must not be empty")
    @Pattern(regexp="[\\d]{1,3}", message = "The house number must be of number format (3 digits)")
    private String houseNo;

    public AddressDto(String country, String city, String street,  String houseNo) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
    }

    public Address getAddressModel() {
        return new Address(country, city, street, Integer.parseInt(houseNo));
    }
}
