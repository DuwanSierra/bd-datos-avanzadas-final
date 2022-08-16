package com.udistrital.controlprojectsbackend.command.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditGrupoInvestigacionCommand {
    Mono<GrupoInvestigacionDto> EditGrupoInvestigacion(GrupoInvestigacionDto grupoInvestigacionDto, String nombre, String codigo);
}
