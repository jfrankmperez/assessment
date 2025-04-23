package com.challange.challange_april.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {
    private Timestamp timestamp;
    private int code;
    private List<String> message;
}
