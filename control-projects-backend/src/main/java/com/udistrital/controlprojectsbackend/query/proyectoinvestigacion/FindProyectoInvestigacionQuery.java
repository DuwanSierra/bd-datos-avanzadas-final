package com.udistrital.controlprojectsbackend.query.proyectoinvestigacion;

import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindProyectoInvestigacionQuery {
    Mono<Page<ProyectoInvestigacionDto>> FindAllProyectoInvestigacion(long page, long size);
}
