package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.SedeDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateSedeCommand {
    Mono<SedeDto> CreateSede(SedeDto sedeDto);
}
