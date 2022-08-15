package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.grupoinvestigacion.CreateGrupoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.grupoinvestigacion.DeleteGrupoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.grupoinvestigacion.EditGrupoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.sede.CreateSedeCommand;
import com.udistrital.controlprojectsbackend.command.sede.DeleteSedeCommand;
import com.udistrital.controlprojectsbackend.command.sede.EditSedeCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.query.sede.FindSedeByIdQuery;
import com.udistrital.controlprojectsbackend.query.sede.FindSedeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/grupo-investigacion")
@CrossOrigin(origins = "http://localhost:4200")
public class GrupoInvestigacionController {
    private CreateGrupoInvestigacionCommand _createGrupoInvestigacionCommand;
    private FindSedeQuery _findSedeQuery;
    private DeleteGrupoInvestigacionCommand _deleteGrupoInvestigacionCommand;
    private FindSedeByIdQuery _findSedeByIdQuery;
    private EditGrupoInvestigacionCommand _editGrupoInvestigacionCommand;

    @Autowired
    public GrupoInvestigacionController(
            CreateGrupoInvestigacionCommand createGrupoInvestigacionCommand,
            FindSedeQuery findSedeQuery,
            DeleteGrupoInvestigacionCommand deleteGrupoInvestigacionCommand,
            FindSedeByIdQuery findSedeByIdQuery,
            EditGrupoInvestigacionCommand editGrupoInvestigacionCommand
    ) {
        _createGrupoInvestigacionCommand = createGrupoInvestigacionCommand;
        _findSedeQuery = findSedeQuery;
        _deleteGrupoInvestigacionCommand = deleteGrupoInvestigacionCommand;
        _findSedeByIdQuery = findSedeByIdQuery;
        _editGrupoInvestigacionCommand = editGrupoInvestigacionCommand;
    }

    @PostMapping("/create")
    private Mono<GrupoInvestigacionDto> createGrupoInvestigacion(@RequestBody GrupoInvestigacionDto grupoInvestigacionDto) {
        return _createGrupoInvestigacionCommand.CreateGrupoInvestigacion(grupoInvestigacionDto);
    }

    @PutMapping("/edit/{nombre}/{codigo}")
    private Mono<GrupoInvestigacionDto> editGrupoInvestigacion(@RequestBody GrupoInvestigacionDto grupoInvestigacionDto, @PathVariable String nombre, @PathVariable String codigo) {
        return _editGrupoInvestigacionCommand.EditGrupoInvestigacion(grupoInvestigacionDto,nombre,codigo);
    }

    @GetMapping("/all")
    private Mono<Page<SedeDto>> getAllGrupoInvestigacion(@RequestParam long page, @RequestParam long size) {
        return _findSedeQuery.FindAllSede(page, size);
    }

    @DeleteMapping("/delete/{nombre}/{codigo}")
    private Mono<DeleteDto> deleteGrupoInvestigacion(@PathVariable String nombre, @PathVariable String codigo) {
        return _deleteGrupoInvestigacionCommand.deleteGrupoInvestigacion(nombre,codigo);
    }

    @GetMapping("/find/{id}")
    private Mono<SedeDto> findSede(@PathVariable long id) {
        return _findSedeByIdQuery.FindSedeById(id);
    }
}
