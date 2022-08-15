package com.udistrital.controlprojectsbackend.query.participa;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindParticipaQuery {
    Mono<Page<ParticipaDto>> FindAllParticipa(long page, long size, String nombreGrupo, String codigoGrupo, String codigoProyecto);
}
