package com.udistrital.controlprojectsbackend.command.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.mappers.ProyectoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProyectoInvestigacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProyectoInvestigacionCommandHandler implements CreateProyectoInvestigacionCommand {

    private final ProyectoInvestigacionRepository _proyectoInvestigacionRepository;
    private final ProyectoInvestigacionMapper _proyectoInvestigacionMapper;

    @Autowired
    public CreateProyectoInvestigacionCommandHandler(
            ProyectoInvestigacionRepository proyectoInvestigacionRepository,
            ProyectoInvestigacionMapper proyectoInvestigacionMapper) {
        _proyectoInvestigacionRepository = proyectoInvestigacionRepository;
        _proyectoInvestigacionMapper = proyectoInvestigacionMapper;
    }

    @Override
    public Mono<ProyectoInvestigacionDto> CreateProyectoInvestigacion(ProyectoInvestigacionDto proyectoInvestigacionDto) {
        return Mono.fromCallable(() -> {
            try {
                ProyectoInvestigacionEntity proyectoInvestigacionEntity = _proyectoInvestigacionMapper.convertProyectoInvestigacionDtoToProyectoInvestigacionEntity(proyectoInvestigacionDto);
                proyectoInvestigacionEntity = _proyectoInvestigacionRepository.save(proyectoInvestigacionEntity);
                return _proyectoInvestigacionMapper.convertProyectoInvestigacionEntityToProyectoInvestigacionDto(proyectoInvestigacionEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear e", e.getMessage());
            }
        });
    }
}
