package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProyectoInvestigacionMapper {
    @Autowired
    GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Mapping(target = "proyectoInvestigacionId", expression = "java(generateIdFromProyectoInvestigacionDto(proyectoInvestigacionDto))")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "valorPres", source = "presupuesto")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaTerminacion", source = "fechaTerminacion")
    public abstract ProyectoInvestigacionEntity convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(ProyectoInvestigacionDto proyectoInvestigacionDto);

    @Mapping(target = "codigo", expression = "java(proyectoInvestigacionEntity.getProyectoInvestigacionId().getCodigoProyecto())")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "presupuesto", source = "valorPres")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaTerminacion", source = "fechaTerminacion")
    @Mapping(target = "grupoInvestigacion", expression = "java(_grupoInvestigacionMapper.convertGrupoInvestigacionEntityToGrupoInvestigacionDto(proyectoInvestigacionEntity.getProyectoInvestigacionId().getGrupoInvestigacion()))")
    public abstract ProyectoInvestigacionDto convertProyectoInvestigacionEntityToProyectoInvestigacionDto(ProyectoInvestigacionEntity proyectoInvestigacionEntity);

    @Mapping(target = "codigoProyecto", source = "codigo")
    @Mapping(target = "grupoInvestigacion", expression = "java(_grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(proyectoInvestigacionDto.getGrupoInvestigacion()))")
    public abstract ProyectoInvestigacionId generateIdFromProyectoInvestigacionDto(ProyectoInvestigacionDto proyectoInvestigacionDto);
}
