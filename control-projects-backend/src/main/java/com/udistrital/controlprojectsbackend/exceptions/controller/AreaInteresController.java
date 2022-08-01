package com.udistrital.controlprojectsbackend.exceptions.controller;

import com.udistrital.controlprojectsbackend.command.areainteres.CreateAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.areainteres.DeleteAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.areainteres.EditAreaInteresCommand;
import com.udistrital.controlprojectsbackend.exceptions.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.exceptions.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.query.area.FindAreaInteresByIdQuery;
import com.udistrital.controlprojectsbackend.query.area.FindAreaInteresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/area-interes")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaInteresController {

    private CreateAreaInteresCommand _createAreaInteresCommand;
    private FindAreaInteresQuery _findAreaInteresQuery;
    private DeleteAreaInteresCommand _deleteAreaInteresCommand;
    private FindAreaInteresByIdQuery _findAreaInteresByIdQuery;
    private EditAreaInteresCommand _editAreaInteresCommand;

    public AreaInteresController(@Autowired CreateAreaInteresCommand createAreaInteresCommand,
                                 @Autowired FindAreaInteresQuery findAreaInteresQuery,
                                 @Autowired DeleteAreaInteresCommand deleteAreaInteresCommand,
                                 @Autowired FindAreaInteresByIdQuery findAreaInteresByIdQuery,
                                 @Autowired EditAreaInteresCommand editAreaInteresCommand
                                 ){
        _createAreaInteresCommand = createAreaInteresCommand;
        _findAreaInteresQuery = findAreaInteresQuery;
        _deleteAreaInteresCommand = deleteAreaInteresCommand;
        _findAreaInteresByIdQuery = findAreaInteresByIdQuery;
        _editAreaInteresCommand = editAreaInteresCommand;
    }
    @PostMapping("/create")
    private Mono<AreaInteresDto> createAreaInteres(@RequestBody AreaInteresDto areaInteresDto) {
        return _createAreaInteresCommand.CreateAreaInteres(areaInteresDto);
    }
    @PutMapping("/edit/{id}")
    private Mono<AreaInteresDto> editAreaInteres(@RequestBody AreaInteresDto areaInteresDto, @PathVariable long id) {
        return _editAreaInteresCommand.EditAreaInteres(areaInteresDto,id);
    }
    @GetMapping("/all")
    private Mono<Page<AreaInteresDto>> getAllAreaInteres(@RequestParam long page, @RequestParam long size) {
        return _findAreaInteresQuery.FindAllAreaInteres(page,size);
    }
    @DeleteMapping("/delete/{id}")
    private Mono<DeleteDto> deleteAreaInteres(@PathVariable long id) {
        return _deleteAreaInteresCommand.deleteAreaInteres(id);
    }
    @GetMapping("/find/{id}")
    private Mono<AreaInteresDto> findAreaInteres(@PathVariable long id) {
        return _findAreaInteresByIdQuery.FindAreaInteresById(id);
    }
}
