package com.challange.challange_april.infrastructure.controller;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.application.port.input.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoResponse saveUser (@RequestBody UserDtoRequest userDtoRequest){
        return userUseCase.registerUser(userDtoRequest);
    }

}
