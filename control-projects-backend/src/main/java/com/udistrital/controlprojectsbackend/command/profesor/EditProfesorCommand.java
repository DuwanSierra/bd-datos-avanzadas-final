package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditProfesorCommand {
    Mono<ProfesorDto> EditProfesor(ProfesorDto profesorDto, Long id);
}
