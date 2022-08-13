package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RolMapper {
    @Mapping(target = "rolId", source = "rolId")
    @Mapping(target = "rol", source = "rol")
    public abstract RolDto rolEntityToRolDto(RolEntity rolEntity);
    @Mapping(target = "rolId", source = "rolId")
    @Mapping(target = "rol", source = "rol")
    public abstract RolEntity rolDtoToRolEntity(RolDto rolDto);
}
