package com.udistrital.controlprojectsbackend.command.rol;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditRolCommand {
    Mono<RolDto> EditRol(RolDto rolDto, long id);
}
