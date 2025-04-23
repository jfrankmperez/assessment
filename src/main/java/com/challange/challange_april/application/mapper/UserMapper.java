package com.challange.challange_april.application.mapper;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.domain.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {
    @Mapping(target = "isActive", expression = "java(true)")
    UserEntity toEntity (UserDtoRequest userDtoRequest);
    UserDtoResponse toDtoResponse(UserEntity userEntity);
}
