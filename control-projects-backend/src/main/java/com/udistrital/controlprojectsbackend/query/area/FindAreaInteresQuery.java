package com.udistrital.controlprojectsbackend.query.area;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface FindAreaInteresQuery {
    Mono<Page<AreaInteresDto>> FindAllAreaInteres(long page, long size);
}
