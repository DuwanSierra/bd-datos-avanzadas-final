package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditFacultadCommand {
    Mono<CargoDto> EditCargo(CargoDto cargoDto, long id);
}
