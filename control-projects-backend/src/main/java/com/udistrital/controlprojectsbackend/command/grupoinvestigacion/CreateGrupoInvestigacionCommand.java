package com.udistrital.controlprojectsbackend.command.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateGrupoInvestigacionCommand {
    Mono<GrupoInvestigacionDto> CreateGrupoInvestigacion(GrupoInvestigacionDto grupoInvestigacionDto);
}
