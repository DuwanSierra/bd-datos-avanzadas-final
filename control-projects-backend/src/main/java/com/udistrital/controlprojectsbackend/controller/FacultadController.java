package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.facultad.CreateFacultadCommand;
import com.udistrital.controlprojectsbackend.command.facultad.DeleteFacultadCommand;
import com.udistrital.controlprojectsbackend.command.facultad.EditFacultadCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.FacultadDto;
import com.udistrital.controlprojectsbackend.query.facultad.FindFacultadByIdQuery;
import com.udistrital.controlprojectsbackend.query.facultad.FindFacultadQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/facultad")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultadController {
    private final CreateFacultadCommand _createFacultadCommand;
    private final FindFacultadQuery _findFacultadQuery;
    private final DeleteFacultadCommand _deleteFacultadCommand;
    private final FindFacultadByIdQuery _findFacultadByIdQuery;
    private final EditFacultadCommand _editFacultadCommand;

    @Autowired
    public FacultadController(CreateFacultadCommand createFacultadCommand,
                              FindFacultadQuery findFacultadQuery,
                              DeleteFacultadCommand deleteFacultadCommand,
                              FindFacultadByIdQuery findFacultadByIdQuery,
                              EditFacultadCommand editFacultadCommand
    ) {
        _createFacultadCommand = createFacultadCommand;
        _findFacultadQuery = findFacultadQuery;
        _deleteFacultadCommand = deleteFacultadCommand;
        _findFacultadByIdQuery = findFacultadByIdQuery;
        _editFacultadCommand = editFacultadCommand;
    }

    @PostMapping("/create")
    private Mono<FacultadDto> createFacultad(@RequestBody FacultadDto facultadDto) {
        return _createFacultadCommand.CreateFacultad(facultadDto);
    }

    @PutMapping("/edit/{id}")
    private Mono<FacultadDto> editRol(@RequestBody FacultadDto facultadDto, @PathVariable String id) {
        return _editFacultadCommand.EditFacultad(facultadDto, id);
    }

    @GetMapping("/all")
    private Mono<Page<FacultadDto>> getAllFacultad(@RequestParam long page, @RequestParam long size) {
        return _findFacultadQuery.FindAllFacultad(page, size);
    }

    @DeleteMapping("/delete/{id}")
    private Mono<DeleteDto> deleteRol(@PathVariable String id) {
        return _deleteFacultadCommand.deleteFacultad(id);
    }

    @GetMapping("/find/{id}")
    private Mono<FacultadDto> findFacultad(@PathVariable String id) {
        return _findFacultadByIdQuery.FindFacultadByid(id);
    }
}
