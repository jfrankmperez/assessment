package com.challange.challange_april.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoResponse {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private LocalDateTime created;

    private LocalDateTime modified;

    private LocalDateTime lastlogin;

    private String token;

    private boolean isactive;
}
