package com.udistrital.controlprojectsbackend.command.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteGrupoInvestigacionCommand {
    Mono<DeleteDto> deleteGrupoInvestigacion(String nombre, String codigo);
}
