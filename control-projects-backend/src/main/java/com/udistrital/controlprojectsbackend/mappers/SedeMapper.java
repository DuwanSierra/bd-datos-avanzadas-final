package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SedeMapper {
    @Mapping(target = "sedeId", source = "idSede")
    @Mapping(target = "nombre", source = "sede")
    public abstract SedeDto sedeEntityToSedeDto(SedeEntity source);

    @Mapping(source = "sedeId", target = "idSede")
    @Mapping(source = "nombre", target = "sede")
    public abstract SedeEntity sedeDtoToSedeEntity(SedeDto sedeDto);
}
