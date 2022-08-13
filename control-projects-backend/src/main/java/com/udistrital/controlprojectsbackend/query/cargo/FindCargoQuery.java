package com.udistrital.controlprojectsbackend.query.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindCargoQuery {
    Mono<Page<CargoDto>> FindAllCargos(long page, long size);
}
