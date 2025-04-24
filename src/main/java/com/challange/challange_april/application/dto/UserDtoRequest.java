package com.challange.challange_april.application.dto;

import jakarta.validation.Valid;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static com.challange.challange_april.application.constants.UserConstants.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {

    @NotBlank(message = NAME_VALIDATION_BLANK_MESSAGE)
    @Pattern(regexp = "^[a-zA-Z ]+$", message = NAME_VALIDATION_MESSAGE)
    private String name;

    @NotBlank(message = EMAIL_VALIDATION_BLANK_MESSAGE)
    @Email(message = EMAIL_VALIDATION_MESSAGE)
    private String email;

    @NotBlank(message = PASSWORD_VALIDATION_BLANK_MESSAGE)
    @Pattern(regexp = "^(?=.*[A-Z])(?=(?:.*\\d){2})(?!.*\\d{3,})[a-zA-Z\\d]{8,12}$", message = PASSWORD_VALIDATION_MESSAGE)
    private String password;

    @Valid
    @NotEmpty(message = PHONE_VALIDATION_MESSAGE)
    private List<PhoneDtoRequest> phones;
}
