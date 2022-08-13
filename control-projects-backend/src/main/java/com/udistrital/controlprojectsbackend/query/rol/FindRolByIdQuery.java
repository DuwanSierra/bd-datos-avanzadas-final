package com.udistrital.controlprojectsbackend.query.rol;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindRolByIdQuery {
    Mono<RolDto> FindRolById(long id);
}
