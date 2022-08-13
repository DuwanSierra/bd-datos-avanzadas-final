package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.profesor.CreateProfesorCommand;
import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/profesor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfesorController {
    private FindProfesorQuery _findProfesorQuery;
    private CreateProfesorCommand _createProfesorCommand;
    @Autowired
    public ProfesorController(FindProfesorQuery findProfesorQuery, CreateProfesorCommand createProfesorCommand){
        _findProfesorQuery = findProfesorQuery;
        _createProfesorCommand = createProfesorCommand;
    }
    @GetMapping("/all")
    private Mono<Page<ProfesorDto>> getAllProfesor(@RequestParam long page, @RequestParam long size) {
        return _findProfesorQuery.FindAllProfesor(page,size);
    }
    @PostMapping("/create")
    private Mono<ProfesorDto> createProfesor(@RequestBody ProfesorDto profesor) {
        return _createProfesorCommand.CreateProfesor(profesor);
    }
}
