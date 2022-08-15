package com.udistrital.controlprojectsbackend.query.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindProfesorByIdQuery {
    Mono<ProfesorDto> FindProfesorById(Long id);
}
