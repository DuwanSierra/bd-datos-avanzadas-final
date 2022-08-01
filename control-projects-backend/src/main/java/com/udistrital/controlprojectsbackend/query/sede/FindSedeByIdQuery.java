package com.udistrital.controlprojectsbackend.query.sede;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.SedeDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindSedeByIdQuery {
    Mono<SedeDto> FindSedeById(long id);
}
