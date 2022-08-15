package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.repository.entity.ParticipaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ParticipaMapper {

    @Autowired
    ProfesorMapper _profesorMapper;
    @Autowired
    ProyectoInvestigacionMapper _proyectoInvestigacionMapper;
    @Autowired
    RolMapper _rolMapper;

    @Mapping(target = "profesor", expression = "java(_profesorMapper.profesorDtoToProfesorEntity(participaDto.getProfesor()))")
    @Mapping(target = "proyecto", expression = "java(_proyectoInvestigacionMapper.convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(participaDto.getProyecto()))")
    @Mapping(target = "rol", expression = "java(_rolMapper.rolDtoToRolEntity(participaDto.getRol()))")
    public abstract ParticipaEntity convertParticipaDtoToParticipaEntity(ParticipaDto participaDto);

    @Mapping(target = "profesor", expression = "java(_profesorMapper.profesorEntityToProfesorDto(participaEntity.getProfesor()))")
    @Mapping(target = "proyecto", expression = "java(_proyectoInvestigacionMapper.convertProyectoInvestigacionEntityToProyectoInvestigacionDto(participaEntity.getProyecto()))")
    @Mapping(target = "rol", expression = "java(_rolMapper.rolEntityToRolDto(participaEntity.getRol()))")
    public abstract ParticipaDto convertParticipaEntityToParticipaDto(ParticipaEntity participaEntity);
}
