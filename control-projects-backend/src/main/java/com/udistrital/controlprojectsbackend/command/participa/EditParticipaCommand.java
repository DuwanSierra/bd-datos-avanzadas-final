package com.udistrital.controlprojectsbackend.command.participa;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditParticipaCommand {
    Mono<ParticipaDto> EditParticipa(ParticipaDto participaDto, String nombreGrupo, String codigoGrupo, String codigoProyecto, Long cedulaProfesor);
}
