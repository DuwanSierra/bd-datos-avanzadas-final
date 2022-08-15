package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProyectoInvestigacionMapper {
    @Autowired
    GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Mapping(target = "codigoProyecto", source = "codigo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "valorPres", source = "presupuesto")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaTerminacion", source = "fechaTerminacion")
    @Mapping(target = "grupoInvestigacion", expression = "java(_grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(proyectoInvestigacionDto.getGrupoInvestigacion()))")
    public abstract ProyectoInvestigacionEntity convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(ProyectoInvestigacionDto proyectoInvestigacionDto);

    @Mapping(target = "codigo", source = "codigoProyecto")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "presupuesto", source = "valorPres")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaTerminacion", source = "fechaTerminacion")
    @Mapping(target = "grupoInvestigacion", expression = "java(_grupoInvestigacionMapper.convertGrupoInvestigacionEntityToGrupoInvestigacionDto(proyectoInvestigacionEntity.getGrupoInvestigacion()))")
    public abstract ProyectoInvestigacionDto convertProyectoInvestigacionEntityToProyectoInvestigacionDto(ProyectoInvestigacionEntity proyectoInvestigacionEntity);
}
