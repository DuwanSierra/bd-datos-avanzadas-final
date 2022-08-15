package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditFacultadCommand {
    Mono<FacultadDto> EditFacultad(FacultadDto facultadDto, String id);
}
