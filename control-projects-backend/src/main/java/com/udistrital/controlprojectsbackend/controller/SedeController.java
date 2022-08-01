package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.areainteres.CreateAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.areainteres.DeleteAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.areainteres.EditAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.sede.CreateSedeCommand;
import com.udistrital.controlprojectsbackend.command.sede.DeleteSedeCommand;
import com.udistrital.controlprojectsbackend.command.sede.EditSedeCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.query.sede.FindSedeByIdQuery;
import com.udistrital.controlprojectsbackend.query.sede.FindSedeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/sede")
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {
    private CreateSedeCommand _createSedeCommand;
    private FindSedeQuery _findSedeQuery;
    private DeleteSedeCommand _deleteSedeCommand;
    private FindSedeByIdQuery _findSedeByIdQuery;
    private EditSedeCommand _editSedeCommand;

    public SedeController(@Autowired CreateSedeCommand createSedeCommand,
                                 @Autowired FindSedeQuery findSedeQuery,
                                 @Autowired DeleteSedeCommand deleteSedeCommand,
                                 @Autowired FindSedeByIdQuery findSedeByIdQuery,
                                 @Autowired EditSedeCommand editSedeCommand
    ){
        _createSedeCommand = createSedeCommand;
        _findSedeQuery = findSedeQuery;
        _deleteSedeCommand = deleteSedeCommand;
        _findSedeByIdQuery = findSedeByIdQuery;
        _editSedeCommand = editSedeCommand;
    }
    @PostMapping("/create")
    private Mono<SedeDto> createAreaInteres(@RequestBody SedeDto sedeDto) {
        return _createSedeCommand.CreateSede(sedeDto);
    }
    @PutMapping("/edit/{id}")
    private Mono<SedeDto> editAreaInteres(@RequestBody SedeDto sedeDto, @PathVariable long id) {
        return _editSedeCommand.EditSede(sedeDto,id);
    }
    @GetMapping("/all")
    private Mono<Page<SedeDto>> getAllAreaInteres(@RequestParam long page, @RequestParam long size) {
        return _findSedeQuery.FindAllSede(page,size);
    }
    @DeleteMapping("/delete/{id}")
    private Mono<DeleteDto> deleteAreaInteres(@PathVariable long id) {
        return _deleteSedeCommand.deleteSede(id);
    }
    @GetMapping("/find/{id}")
    private Mono<SedeDto> findAreaInteres(@PathVariable long id) {
        return _findSedeByIdQuery.FindSedeById(id);
    }
}
