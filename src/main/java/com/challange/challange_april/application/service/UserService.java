package com.challange.challange_april.application.service;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.application.port.input.UserUseCase;
import com.challange.challange_april.application.port.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public UserDtoResponse registerUser(UserDtoRequest userDtoRequest) {
        return userRepositoryPort.registerUser(userDtoRequest);
    }
}
