package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.TelefonoDto;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class TelefonoMapper {
    @Mapping(target = "telefono", expression = "java(telefonoDto.getTelefono())")
    @Mapping(target = "facultad", expression = "java(facultadEntity)")
    public abstract TelefonoEntity convertTelefonoDtoToTelefonoEntity(TelefonoDto telefonoDto, FacultadEntity facultadEntity);

    @Mapping(target = "telefono", source = "telefono")
    public abstract TelefonoDto convertTelefonoEntityToTelefonoDto(TelefonoEntity telefonoEntity);
    public List<TelefonoEntity> convertListTelefonotDtoToListTelefonoEntity(List<TelefonoDto> telefonoDtos, FacultadEntity facultadEntity) {
        if (telefonoDtos == null || telefonoDtos.size() == 0) {
            return null;

        }
        return telefonoDtos.stream().map(telefono -> convertTelefonoDtoToTelefonoEntity(telefono, facultadEntity)).collect(Collectors.toList());

    }
    public List<TelefonoDto> convertListTelefonotEntityToListTelefonoDto(List<TelefonoEntity> telefonoEntities) {
        if (telefonoEntities == null || telefonoEntities.size() == 0) {
            return null;

        }
        return telefonoEntities.stream().map(this::convertTelefonoEntityToTelefonoDto).collect(Collectors.toList());
    }
}
