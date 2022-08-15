package com.udistrital.controlprojectsbackend.query.grupoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindGrupoInvestigacionQuery {
    Mono<Page<GrupoInvestigacionDto>> FindAllGrupoInvestigacion(long page, long size);
}
