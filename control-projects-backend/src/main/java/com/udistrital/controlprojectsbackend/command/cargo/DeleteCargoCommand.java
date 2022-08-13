package com.udistrital.controlprojectsbackend.command.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteCargoCommand {
    Mono<DeleteDto> deleteCargo(long id);
}
