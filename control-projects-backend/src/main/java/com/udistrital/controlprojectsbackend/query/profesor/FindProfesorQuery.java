package com.udistrital.controlprojectsbackend.query.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindProfesorQuery {
    Mono<Page<ProfesorDto>> FindAllProfesor(long page, long size);
}
