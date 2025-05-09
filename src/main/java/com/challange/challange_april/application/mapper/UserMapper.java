package com.challange.challange_april.application.mapper;

import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.application.dto.UserDtoResponse;
import com.challange.challange_april.domain.model.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, injectionStrategy = InjectionStrategy.FIELD, unmappedTargetPolicy = IGNORE)
public interface UserMapper {

    @Mapping(target = "isactive", expression = "java(true)")
    UserEntity toEntity (UserDtoRequest userDtoRequest);

    UserDtoResponse toDtoResponse(UserEntity userEntity);
}
