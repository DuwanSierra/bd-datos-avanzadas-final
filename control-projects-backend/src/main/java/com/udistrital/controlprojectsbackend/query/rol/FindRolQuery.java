package com.udistrital.controlprojectsbackend.query.rol;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface FindRolQuery {
    Mono<Page<RolDto>> FindAllRol(long page, long size);
}
