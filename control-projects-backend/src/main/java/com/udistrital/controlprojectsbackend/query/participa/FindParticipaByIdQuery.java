package com.udistrital.controlprojectsbackend.query.participa;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindParticipaByIdQuery {
    Mono<ParticipaDto> FindParticipaByid(String nombreGrupo, String codigoGrupo, String codigoProyecto, Long cedulaProfesor);
}
