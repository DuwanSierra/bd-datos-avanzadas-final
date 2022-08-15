package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.profesor.CreateProfesorCommand;
import com.udistrital.controlprojectsbackend.command.profesor.DeleteProfesorCommand;
import com.udistrital.controlprojectsbackend.command.profesor.EditProfesorCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorByIdQuery;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/profesor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfesorController {
    private final FindProfesorQuery _findProfesorQuery;
    private final CreateProfesorCommand _createProfesorCommand;
    private final DeleteProfesorCommand _deleteProfesorCommand;
    private final EditProfesorCommand _editProfesorCommand;
    private final FindProfesorByIdQuery _findProfesorByIdQuery;
    @Autowired
    public ProfesorController(FindProfesorQuery findProfesorQuery,
                              CreateProfesorCommand createProfesorCommand,
                              DeleteProfesorCommand deleteProfesorCommand,
                              EditProfesorCommand editProfesorCommand,
                              FindProfesorByIdQuery findProfesorByIdQuery
    ){
        _findProfesorQuery = findProfesorQuery;
        _createProfesorCommand = createProfesorCommand;
        _deleteProfesorCommand = deleteProfesorCommand;
        _editProfesorCommand = editProfesorCommand;
        _findProfesorByIdQuery = findProfesorByIdQuery;
    }
    @GetMapping("/all")
    private Mono<Page<ProfesorDto>> getAllProfesor(@RequestParam long page, @RequestParam long size) {
        return _findProfesorQuery.FindAllProfesor(page,size);
    }
    @PostMapping("/create")
    private Mono<ProfesorDto> createProfesor(@RequestBody ProfesorDto profesor) {
        return _createProfesorCommand.CreateProfesor(profesor);
    }
    @PutMapping("/edit/{id}")
    private Mono<ProfesorDto> editRol(@RequestBody ProfesorDto profesorDto, @PathVariable Long id) {
        return _editProfesorCommand.EditProfesor(profesorDto, id);
    }
    @DeleteMapping("/delete/{id}")
    private Mono<DeleteDto> deleteRol(@PathVariable Long id) {
        return _deleteProfesorCommand.deleteProfesor(id);
    }
    @GetMapping("/find/{id}")
    private Mono<ProfesorDto> findRol(@PathVariable Long id) {
        return _findProfesorByIdQuery.FindProfesorById(id);
    }
}
