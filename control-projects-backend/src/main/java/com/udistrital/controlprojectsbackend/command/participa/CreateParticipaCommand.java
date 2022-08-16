package com.udistrital.controlprojectsbackend.command.participa;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateParticipaCommand {
    Mono<ParticipaDto> CreateParticipa(ParticipaDto participaDto);
}
