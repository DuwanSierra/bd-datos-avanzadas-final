package com.udistrital.controlprojectsbackend.command.areainteres;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditAreaInteresCommand {
    Mono<AreaInteresDto> EditAreaInteres(AreaInteresDto areaInteresDto, long id);
}
