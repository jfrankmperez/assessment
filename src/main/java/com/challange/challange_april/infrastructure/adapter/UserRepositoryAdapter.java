package com.challange.challange_april.infrastructure.adapter;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.application.mapper.UserMapper;
import com.challange.challange_april.application.port.output.UserRepositoryPort;
import com.challange.challange_april.domain.exceptions.EmailAlreadyRegisterException;
import com.challange.challange_april.domain.model.UserEntity;
import com.challange.challange_april.infrastructure.adapter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDtoResponse registerUser(UserDtoRequest userDtoRequest) {
    userRepository.findByEmail(userDtoRequest.getEmail())
            .ifPresent(userAlreadyRegistered ->{
                throw new EmailAlreadyRegisterException("Email exists");
                    }
            );
        UserEntity userToRegister = userMapper.toEntity(userDtoRequest);
        userToRegister.setId(UUID.randomUUID().toString());
        userToRegister.setCreated(LocalDateTime.now());
        userToRegister.setModified(LocalDateTime.now());
        userToRegister.setLastlogin(LocalDateTime.now());
        userToRegister.setToken(UUID.randomUUID().toString());
        userToRegister.getPhones().forEach(
                phoneEntity -> phoneEntity.setUser(userToRegister));

        return userMapper.toDtoResponse(userRepository.save(userToRegister));
    }
}
