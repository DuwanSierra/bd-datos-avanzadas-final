package com.udistrital.controlprojectsbackend.command.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateProyectoInvestigacionCommand {
    Mono<ProyectoInvestigacionDto> CreateProyectoInvestigacion(ProyectoInvestigacionDto proyectoInvestigacionDto);
}
