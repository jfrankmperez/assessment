package com.challange.challange_april.application.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.challange.challange_april.application.constants.UserConstants.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDtoRequest {

    @NotBlank(message = NUMBER_VALIDATION_BLANK_MESSAGE)
    @Digits(integer = 20, fraction = 0, message = NUMBER_VALIDATION_MESSAGE)
    private String number;

    @NotBlank(message = CITYCODE_VALIDATION_BLANK_MESSAGE)
    @Pattern(regexp = "^[0-9]+$", message = CITYCODE_VALIDATION_MESSAGE)
    private String citycode;

    @NotBlank(message = CONTRYCODE_VALIDATION_BLANK_MESSAGE)
    @Pattern(regexp = "^[0-9]+$", message = CONTRYCODE_VALIDATION_MESSAGE)
    private String countrycode;

}
