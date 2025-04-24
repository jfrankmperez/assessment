package com.challange.challange_april;

import com.challange.challange_april.application.dto.PhoneDtoRequest;
import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.application.mapper.UserMapper;
import com.challange.challange_april.domain.exceptions.EmailAlreadyRegisterException;
import com.challange.challange_april.domain.model.PhoneEntity;
import com.challange.challange_april.domain.model.UserEntity;
import com.challange.challange_april.infrastructure.adapter.UserRepositoryAdapter;
import com.challange.challange_april.infrastructure.adapter.repository.UserRepository;
import com.challange.challange_april.infrastructure.config.JwtConfig;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class ChallangeAprilApplicationTests {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private JwtConfig jwtConfig;

    @InjectMocks
    private UserRepositoryAdapter userRepositoryAdapter;



    @Test
    public void shouldRegisterUserSuccessfully() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setEmail("jfrankmperez@gmail.com");

        UserEntity userEntity = new UserEntity();
        userEntity.setPhones(Collections.emptyList());

        when(userRepository.findByEmail(userDtoRequest.getEmail()))
                .thenReturn(Optional.empty());
        when(userMapper.toEntity(userDtoRequest)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toDtoResponse(any(UserEntity.class))).thenReturn(new UserDtoResponse());

        UserDtoResponse response = userRepositoryAdapter.registerUser(userDtoRequest);

        assertNotNull(response);
        verify(userRepository).save(any(UserEntity.class));
    }

    @Test
    public void emailAlreadyExists(){
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setEmail("jfrankmperez@gmail.com");

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("jfrankmperez@gmail.com");
        when(userRepository.findByEmail(userDtoRequest.getEmail()))
                .thenReturn(Optional.of(userEntity));

        EmailAlreadyRegisterException exception = assertThrows(
                EmailAlreadyRegisterException.class,
                () -> userRepositoryAdapter.registerUser(userDtoRequest));

        assertEquals("Email <jfrankmperez@gmail.com> is already registered", exception.getMessage());
        verify(userRepository, never()).save(any(UserEntity.class));
    }
  }
