package com.challange.challange_april.infrastructure.config;

import com.challange.challange_april.application.dto.ErrorResponseDto;
import com.challange.challange_april.domain.exceptions.EmailAlreadyRegisterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus
    public ResponseEntity<ErrorResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> lisErrors = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());

        ErrorResponseDto resultException = ErrorResponseDto.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .code(status.value())
                .message(lisErrors)
                .build();
        return new ResponseEntity<>(resultException, status);
    }

    @ExceptionHandler(EmailAlreadyRegisterException.class)
    @ResponseStatus
    public ResponseEntity<ErrorResponseDto> userAlreadyRegisteredException(EmailAlreadyRegisterException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDto resultException = ErrorResponseDto.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .code(status.value())
                .message(Collections.singletonList(ex.getMessage()))
                .build();
        return new ResponseEntity<>(resultException, status);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus
    public ResponseEntity<ErrorResponseDto> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseDto resultException = ErrorResponseDto.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .code(status.value())
                .message(Collections.singletonList(ex.getMessage()))
                .build();
        return new ResponseEntity<>(resultException, status);
    }
}
