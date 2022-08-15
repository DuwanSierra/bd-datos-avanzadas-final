package com.udistrital.controlprojectsbackend.command.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.GrupoInvestigacionMapper;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.GrupoInvestigacionRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateGrupoInvestigacionCommandHandler implements CreateGrupoInvestigacionCommand {

    private final GrupoInvestigacionRepository _grupoInvestigacionRepository;
    private final GrupoInvestigacionMapper _grupoInvestigacionMapper;

    @Autowired
    public CreateGrupoInvestigacionCommandHandler(
            GrupoInvestigacionRepository grupoInvestigacionRepository,
            GrupoInvestigacionMapper grupoInvestigacionMapper) {
        _grupoInvestigacionRepository = grupoInvestigacionRepository;
        _grupoInvestigacionMapper = grupoInvestigacionMapper;
    }

    @Override
    public Mono<GrupoInvestigacionDto> CreateGrupoInvestigacion(GrupoInvestigacionDto grupoInvestigacionDto) {
        return Mono.fromCallable(() -> {
            try {
                GrupoInvestigacionEntity grupoInvestigacionEntity = _grupoInvestigacionMapper.convertGrupoInvestigacionDtoToGrupoInvestigacionEntity(grupoInvestigacionDto);
                grupoInvestigacionEntity = _grupoInvestigacionRepository.save(grupoInvestigacionEntity);
                return _grupoInvestigacionMapper.convertGrupoInvestigacionEntityToGrupoInvestigacionDto(grupoInvestigacionEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear e", e.getMessage());
            }
        });
    }
}
