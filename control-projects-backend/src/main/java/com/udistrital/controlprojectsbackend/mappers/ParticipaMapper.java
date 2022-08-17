package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.repository.entity.ParticipaEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ParticipaId;
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

    @Mapping(target = "rol", expression = "java(_rolMapper.rolDtoToRolEntity(participaDto.getRol()))")
    @Mapping(target = "participaId", expression = "java(generateParticipaId(participaDto))")
    public abstract ParticipaEntity convertParticipaDtoToParticipaEntity(ParticipaDto participaDto);

    @Mapping(target = "rol", expression = "java(_rolMapper.rolEntityToRolDto(participaEntity.getRol()))")
    public abstract ParticipaDto convertParticipaEntityToParticipaDto(ParticipaEntity participaEntity);

    @Mapping(target = "profesor", expression = "java(_profesorMapper.profesorDtoToProfesorEntity(participaDto.getProfesor()))")
    @Mapping(target = "proyecto", expression = "java(_proyectoInvestigacionMapper.convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(participaDto.getProyecto()))")
    public abstract ParticipaId generateParticipaId(ParticipaDto participaDto);
}
