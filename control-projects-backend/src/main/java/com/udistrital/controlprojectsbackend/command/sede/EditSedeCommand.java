package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditSedeCommand {
    Mono<SedeDto> EditSede(SedeDto sedeDto, long id);
}
