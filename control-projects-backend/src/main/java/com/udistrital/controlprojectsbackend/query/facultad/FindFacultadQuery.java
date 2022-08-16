package com.udistrital.controlprojectsbackend.query.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindFacultadQuery {
    Mono<Page<FacultadDto>> FindAllFacultad(long page, long size);
}
