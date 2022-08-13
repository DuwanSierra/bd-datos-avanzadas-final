package com.udistrital.controlprojectsbackend.command.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateCargoCommand {
    Mono<CargoDto> CreateCargo(CargoDto cargoDto);
}
