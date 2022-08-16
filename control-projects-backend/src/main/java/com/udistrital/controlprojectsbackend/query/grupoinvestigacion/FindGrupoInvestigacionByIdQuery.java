package com.udistrital.controlprojectsbackend.query.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindGrupoInvestigacionByIdQuery {
    Mono<GrupoInvestigacionDto> FindGrupoInvestigacionByid(String nombre, String codigo);
}
