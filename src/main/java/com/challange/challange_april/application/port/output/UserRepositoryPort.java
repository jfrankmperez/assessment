package com.challange.challange_april.application.port.output;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;

public interface UserRepositoryPort {
    UserDtoResponse registerUser (UserDtoRequest userDtoRequest);
}
