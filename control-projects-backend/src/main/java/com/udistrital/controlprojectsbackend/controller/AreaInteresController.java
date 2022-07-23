package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.CreateAreaInteresCommand;
import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.query.FindAreaInteresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/area-interes")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaInteresController {

    private CreateAreaInteresCommand _createAreaInteresCommand;
    private FindAreaInteresQuery _findAreaInteresQuery;

    public AreaInteresController(@Autowired CreateAreaInteresCommand createAreaInteresCommand, @Autowired FindAreaInteresQuery findAreaInteresQuery){
        _createAreaInteresCommand = createAreaInteresCommand;
        _findAreaInteresQuery = findAreaInteresQuery;
    }

    @PostMapping("/create")
    private Mono<AreaInteresDto> createAreaInteres(@RequestBody AreaInteresDto areaInteresDto) {
        return _createAreaInteresCommand.CreateAreaInteres(areaInteresDto);
    }

    @GetMapping("/all")
    private Mono<Page<AreaInteresDto>> getAllAreaInteres(@RequestParam long page, @RequestParam long size) {
        return _findAreaInteresQuery.FindAllAreaInteres(page,size);
    }

}
