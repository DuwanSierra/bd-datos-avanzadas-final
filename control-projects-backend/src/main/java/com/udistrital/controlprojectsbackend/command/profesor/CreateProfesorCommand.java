package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateProfesorCommand {
    Mono<ProfesorDto> CreateProfesor(ProfesorDto profesorDto);
}
