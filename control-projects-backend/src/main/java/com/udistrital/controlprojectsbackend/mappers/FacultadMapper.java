package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FacultadMapper {

    @Autowired
    SedeMapper _sedeMapper;

    @Mapping(target = "nombreFacultad", source = "facultadNombre")
    @Mapping(target = "sede", expression = "java(_sedeMapper.sedeDtoToSedeEntity(facultadDto.getSede()))")
    public abstract FacultadEntity facultadDtoToFacultadEntity(FacultadDto facultadDto);

    @Mapping(source = "nombreFacultad", target = "facultadNombre")
    @Mapping(target = "sede", expression = "java(_sedeMapper.sedeEntityToSedeDto(facultadEntity.getSede()))")
    public abstract FacultadDto factultadEntityToFactultadDto(FacultadEntity facultadEntity);
}
