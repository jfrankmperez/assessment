package com.challange.challange_april.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
public class ErrorResponseDto {
    private Timestamp timestamp;
    private int code;
    private List<String> message;
}
