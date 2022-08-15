package com.udistrital.controlprojectsbackend.command.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteProyectoInvestigacionCommand {
    Mono<DeleteDto> deleteProyectoInvestigacion(String nombreGrupo, String codigoGrupo, String codigoProyecto);
}
