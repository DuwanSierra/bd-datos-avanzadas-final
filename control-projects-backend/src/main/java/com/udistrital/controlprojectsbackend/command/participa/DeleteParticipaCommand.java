package com.udistrital.controlprojectsbackend.command.participa;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteParticipaCommand {
    Mono<DeleteDto> deleteParticipa(String nombreGrupo, String codigoGrupo, String codigoProyecto, Long cedulaProfesor);
}
