package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class GrupoInvestigacionMapper {
    @Autowired
    FacultadMapper _facultadMapper;
    @Autowired
    AreaInteresMapper _areaInteresMapper;
    @Autowired
    ProfesorMapper _profesorMapper;
    @Mapping(target = "nombreGrupo", source = "nombreGrupoInvestigacion")
    @Mapping(target = "codigoGrupo", source = "codigoGrupoInvestigacion")
    @Mapping(target = "facultad", expression = "java(_facultadMapper.facultadDtoToFacultadEntity(grupoInvestigacionDto.getFacultad()))")
    @Mapping(target = "areaInteres", expression = "java(_areaInteresMapper.areaInteresDtoToAreaInteresEntity(grupoInvestigacionDto.getAreaInteres()))")
    @Mapping(target = "profesor", expression = "java(_profesorMapper.profesorDtoToProfesorEntity(grupoInvestigacionDto.getProfesor()))")
    public abstract GrupoInvestigacionEntity convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(GrupoInvestigacionDto grupoInvestigacionDto);
    @Mapping(target = "nombreGrupoInvestigacion", source = "nombreGrupo")
    @Mapping(target = "codigoGrupoInvestigacion", source = "codigoGrupo")
    @Mapping(target = "facultad", expression = "java(_facultadMapper.factultadEntityToFactultadDto(grupoInvestigacionEntity.getFacultad()))")
    @Mapping(target = "areaInteres", expression = "java(_areaInteresMapper.areaInteresEntityToAreaInteresDto(grupoInvestigacionEntity.getAreaInteres()))")
    @Mapping(target = "profesor", expression = "java(_profesorMapper.profesorEntityToProfesorDto(grupoInvestigacionEntity.getProfesor()))")
    public abstract GrupoInvestigacionDto convertGrupoInvestigacionEntityToGrupoInvestigacionDto(GrupoInvestigacionEntity grupoInvestigacionEntity);
}
