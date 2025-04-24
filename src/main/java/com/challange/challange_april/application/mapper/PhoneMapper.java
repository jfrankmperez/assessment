package com.challange.challange_april.application.mapper;


import com.challange.challange_april.application.dto.PhoneDtoRequest;
import com.challange.challange_april.application.dto.UserDtoRequest;
import com.challange.challange_april.domain.model.PhoneEntity;
import com.challange.challange_april.domain.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface PhoneMapper {
    PhoneEntity toEntity (PhoneDtoRequest phoneDtoRequest);
}
