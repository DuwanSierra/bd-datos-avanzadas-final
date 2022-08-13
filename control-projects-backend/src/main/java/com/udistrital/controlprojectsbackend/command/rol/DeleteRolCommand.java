package com.udistrital.controlprojectsbackend.command.rol;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteRolCommand {
    Mono<DeleteDto> deleteRol(long id);
}
