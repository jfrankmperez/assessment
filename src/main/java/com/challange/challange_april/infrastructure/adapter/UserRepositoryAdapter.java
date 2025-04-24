package com.challange.challange_april.infrastructure.adapter;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.application.mapper.UserMapper;
import com.challange.challange_april.application.port.output.UserRepositoryPort;
import com.challange.challange_april.domain.exceptions.EmailAlreadyRegisterException;
import com.challange.challange_april.domain.model.UserEntity;
import com.challange.challange_april.infrastructure.adapter.repository.UserRepository;
import com.challange.challange_april.infrastructure.config.security.JwtConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import static com.challange.challange_april.application.constants.UserConstants.EMAIL_ALREADY_REGISTERED_MESSAGE;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;

    @Override
    public UserDtoResponse registerUser(UserDtoRequest userDtoRequest) {
    userRepository.findByEmail(userDtoRequest.getEmail())
            .ifPresent(userAlreadyRegistered ->{
                throw new EmailAlreadyRegisterException(String.format(EMAIL_ALREADY_REGISTERED_MESSAGE, userAlreadyRegistered.getEmail()));
                    }
            );
        String password = passwordEncoder.encode(userDtoRequest.getPassword());

        UserEntity userToRegister = userMapper.toEntity(userDtoRequest);
        userToRegister.setPassword(password);
        userToRegister.setToken(jwtConfig.generateJwts(userToRegister.getEmail()));
        userToRegister.getPhones().forEach(
                phoneEntity -> phoneEntity.setUser(userToRegister));

        return userMapper.toDtoResponse(userRepository.save(userToRegister));
    }
}
