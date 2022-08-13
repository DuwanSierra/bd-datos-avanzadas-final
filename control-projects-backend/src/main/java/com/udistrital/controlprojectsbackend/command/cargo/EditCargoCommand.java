package com.udistrital.controlprojectsbackend.command.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditCargoCommand {
    Mono<CargoDto> EditCargo(CargoDto cargoDto, long id);
}
