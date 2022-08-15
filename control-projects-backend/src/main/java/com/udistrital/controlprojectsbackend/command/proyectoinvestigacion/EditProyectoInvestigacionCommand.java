package com.udistrital.controlprojectsbackend.command.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditProyectoInvestigacionCommand {
    Mono<ProyectoInvestigacionDto> EditProyectoInvestigacion(ProyectoInvestigacionDto proyectoInvestigacionDto, String nombreGrupo, String codigoGrupo, String codigoProyecto);
}
