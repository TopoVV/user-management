package com.topov.usermanagement.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


/**
 * DTO class for birth date data separation in requests.
 */

@Getter
@NoArgsConstructor
public class BirthDateDto {
    @NotEmpty(message = "The day of birth field must not be empty")
    private String birthDay;
    @NotEmpty(message = "The month of birth field must not be empty")
    private String birthMonth;
    @NotEmpty(message = "The year of birth field must not be empty")
    private String birthYear;

    public BirthDateDto(String birthDay, String birthMonth, String birthYear) {
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public LocalDate getDate() {
        return LocalDate.of(
                Integer.parseInt(birthYear),
                Integer.parseInt(birthMonth),
                Integer.parseInt(birthDay)
        );
    }
}
