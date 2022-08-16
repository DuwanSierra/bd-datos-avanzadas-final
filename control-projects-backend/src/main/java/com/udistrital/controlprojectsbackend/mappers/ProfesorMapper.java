package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Mapper(componentModel = "spring")
public abstract class ProfesorMapper {

    @Autowired
    CargoMapper _cargoMapper;

    @Autowired
    FacultadMapper _facultadMapper;

    @Mapping(target = "cedulaProfesor", source = "cedulaProfesor")
    @Mapping(target = "nombreProfesor", source = "nombre")
    @Mapping(target = "inicioInvestigacion", source = "experienciaInv")
    @Mapping(target = "aniosInvestigacion", expression = "java(convertDateToYearsInvestigate(profesorEntity))")
    @Mapping(target = "cargo", expression = "java(_cargoMapper.cargoEntityToCargoDto(profesorEntity.getCargo()))")
    @Mapping(target = "facultad", expression = "java(_facultadMapper.factultadEntityToFactultadDto(profesorEntity.getFacultad()))")
    public abstract ProfesorDto profesorEntityToProfesorDto(ProfesorEntity profesorEntity);
    protected Long convertDateToYearsInvestigate(ProfesorEntity profesorEntity) {
        long diffInMillies = Math.abs(new Date().getTime() - profesorEntity.getExperienciaInv().getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)/360;
    }
    @Mapping(source = "cedulaProfesor", target = "cedulaProfesor")
    @Mapping(source = "nombreProfesor", target = "nombre")
    @Mapping(source = "inicioInvestigacion", target = "experienciaInv")
    @Mapping(target = "cargo", expression = "java(_cargoMapper.cargoDtoToCargoEntity(profesorDto.getCargo()))")
    @Mapping(target = "facultad", expression = "java(_facultadMapper.facultadDtoToFacultadEntity(profesorDto.getFacultad()))")
    public abstract ProfesorEntity profesorDtoToProfesorEntity(ProfesorDto profesorDto);
}
