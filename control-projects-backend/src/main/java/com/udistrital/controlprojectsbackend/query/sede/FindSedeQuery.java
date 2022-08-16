package com.udistrital.controlprojectsbackend.query.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindSedeQuery {
    Mono<Page<SedeDto>> FindAllSede(long page, long size);
}
