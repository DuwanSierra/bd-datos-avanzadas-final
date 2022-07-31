package com.udistrital.controlprojectsbackend.command;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeleteAreaInteresCommand {
    Mono<DeleteDto> deleteAreaInteres(long id);
}
