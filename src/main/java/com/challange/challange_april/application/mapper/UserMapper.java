package com.challange.challange_april.application.mapper;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.domain.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = PhoneMapper.class)
public interface UserMapper {

    @Mapping(target = "active", expression = "java(true)")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "lastlogin", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(source = "phones", target = "phones")
    UserEntity toEntity (UserDtoRequest userDtoRequest);

    UserDtoResponse toDtoResponse(UserEntity userEntity);
}
