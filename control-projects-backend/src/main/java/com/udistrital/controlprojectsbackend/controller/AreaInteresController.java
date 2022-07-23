package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.CreateAreaInteresCommand;
import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/area-interes")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaInteresController {

    private CreateAreaInteresCommand _createAreaInteresCommand;

    public AreaInteresController(@Autowired CreateAreaInteresCommand createAreaInteresCommand){
        _createAreaInteresCommand = createAreaInteresCommand;
    }

    @PostMapping("/create")
    private Mono<AreaInteresDto> getEmployeeById(@RequestBody AreaInteresDto areaInteresDto) {
        return _createAreaInteresCommand.CreateAreaInteres(areaInteresDto);
    }

}
