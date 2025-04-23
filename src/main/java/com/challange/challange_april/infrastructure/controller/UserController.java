package com.challange.challange_april.infrastructure.controller;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.application.port.input.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @Operation(summary = "Registrar nuevo usuario", description = "Crea un nuevo usuario en el sistema")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoResponse saveUser (@Validated @RequestBody UserDtoRequest userDtoRequest){
        return userUseCase.registerUser(userDtoRequest);
    }

}
