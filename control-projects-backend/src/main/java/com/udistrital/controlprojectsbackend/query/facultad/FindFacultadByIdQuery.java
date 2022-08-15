package com.udistrital.controlprojectsbackend.query.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindFacultadByIdQuery {
    Mono<FacultadDto> FindFacultadByid(String id);
}
