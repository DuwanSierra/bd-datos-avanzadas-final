package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.TelefonoDto;
import com.udistrital.controlprojectsbackend.controller.dto.TituloDto;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TituloEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class TituloMapper {
    @Mapping(target = "titulo", expression = "java(titulo.getTitulo())")
    public abstract TituloEntity convertTituloDtoToTituloEntity(TituloDto titulo, ProfesorEntity profesor);
    @Mapping(target = "titulo", source = "titulo")
    public abstract TituloDto convertTituloEntityToTituloDto(TituloEntity tituloEntity);
    @AfterMapping
    protected void setProfesorEntity(@MappingTarget TituloEntity tituloEntity, ProfesorEntity profesor) {
        tituloEntity.setProfesor(profesor);
    }
    public List<TituloEntity> convertListTitulotDtoToListTitulooEntity(List<TituloDto> titulosDto, ProfesorEntity profesorEntity){
        return titulosDto.stream().map(titulo -> convertTituloDtoToTituloEntity(titulo,profesorEntity)).collect(Collectors.toList());
    }
    public List<TituloDto> convertListTitulotEntityToListTituloDto(List<TituloEntity> tituloEntities){
        return tituloEntities.stream().map(this::convertTituloEntityToTituloDto).collect(Collectors.toList());
    }
}
