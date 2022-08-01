package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteSedeCommand {
    Mono<DeleteDto> deleteSede(long id);
}
