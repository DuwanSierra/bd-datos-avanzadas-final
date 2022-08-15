package com.udistrital.controlprojectsbackend.query.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindProyectoInvestigacionByIdQuery {
    Mono<ProyectoInvestigacionDto> FindProyectoInvestigacionByid(String nombreGrupo, String codigoGrupo, String codigo);
}
