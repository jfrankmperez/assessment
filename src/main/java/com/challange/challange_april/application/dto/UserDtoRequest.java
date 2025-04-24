package com.challange.challange_april.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.*;

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
