package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.rol.CreateRolCommand;
import com.udistrital.controlprojectsbackend.command.rol.DeleteRolCommand;
import com.udistrital.controlprojectsbackend.command.rol.EditRolCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.query.rol.FindRolByIdQuery;
import com.udistrital.controlprojectsbackend.query.rol.FindRolQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/facultad")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultadController {
    private final CreateRolCommand _createRolCommand;
    private final FindRolQuery _findRolQuery;
    private final DeleteRolCommand _deleteRolCommand;
    private final FindRolByIdQuery _findRolByIdQuery;
    private final EditRolCommand _editRolCommand;

    @Autowired
    public FacultadController(CreateRolCommand createRolCommand,
                         FindRolQuery findRolQuery,
                         DeleteRolCommand deleteRolCommand,
                         FindRolByIdQuery findRolByIdQuery,
                         EditRolCommand editRolCommand
    ) {
        _createRolCommand = createRolCommand;
        _findRolQuery = findRolQuery;
        _deleteRolCommand = deleteRolCommand;
        _findRolByIdQuery = findRolByIdQuery;
        _editRolCommand = editRolCommand;
    }

    @PostMapping("/create")
    private Mono<RolDto> createRol(@RequestBody RolDto rolDto) {
        return _createRolCommand.CreateRol(rolDto);
    }

    @PutMapping("/edit/{id}")
    private Mono<RolDto> editRol(@RequestBody RolDto rolDto, @PathVariable long id) {
        return _editRolCommand.EditRol(rolDto, id);
    }

    @GetMapping("/all")
    private Mono<Page<RolDto>> getAllRol(@RequestParam long page, @RequestParam long size) {
        return _findRolQuery.FindAllRol(page, size);
    }

    @DeleteMapping("/delete/{id}")
    private Mono<DeleteDto> deleteRol(@PathVariable long id) {
        return _deleteRolCommand.deleteRol(id);
    }

    @GetMapping("/find/{id}")
    private Mono<RolDto> findRol(@PathVariable long id) {
        return _findRolByIdQuery.FindRolById(id);
    }
}
