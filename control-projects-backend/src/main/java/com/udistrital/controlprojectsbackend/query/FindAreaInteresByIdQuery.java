package com.udistrital.controlprojectsbackend.query;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindAreaInteresByIdQuery {
    Mono<AreaInteresDto> FindAreaInteresById(long id);
}
