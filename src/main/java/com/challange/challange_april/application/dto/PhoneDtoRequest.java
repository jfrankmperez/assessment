package com.challange.challange_april.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDtoRequest {

    @NotBlank
    private String number;

    @NotBlank
    private String cityCode;

    @NotBlank
    private String countryCode;

}
