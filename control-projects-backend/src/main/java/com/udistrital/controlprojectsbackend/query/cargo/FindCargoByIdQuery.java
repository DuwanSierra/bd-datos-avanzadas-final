package com.udistrital.controlprojectsbackend.query.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindCargoByIdQuery {
    Mono<CargoDto> FindCargoById(long id);
}
