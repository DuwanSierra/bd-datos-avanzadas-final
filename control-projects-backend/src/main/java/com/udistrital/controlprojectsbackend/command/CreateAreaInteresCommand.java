package com.udistrital.controlprojectsbackend.command;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface CreateAreaInteresCommand {
    Mono<AreaInteresDto> CreateAreaInteres(AreaInteresDto areaInteresDto);
}
