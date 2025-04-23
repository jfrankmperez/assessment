package com.challange.challange_april.application.port.input;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;

public interface UserUseCase {
    UserDtoResponse registerUser (UserDtoRequest userDtoRequest);
}
