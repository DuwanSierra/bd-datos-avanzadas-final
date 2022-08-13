package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteFacultadCommand {
    Mono<DeleteDto> deleteCargo(long id);
}
