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
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionQuery;
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
    private FindGrupoInvestigacionQuery _findGrupoInvestigacionQuery;
    private DeleteGrupoInvestigacionCommand _deleteGrupoInvestigacionCommand;
    private FindGrupoInvestigacionByIdQuery _findGrupoInvestigacionByIdQuery;
    private EditGrupoInvestigacionCommand _editGrupoInvestigacionCommand;

    @Autowired
    public GrupoInvestigacionController(
            CreateGrupoInvestigacionCommand createGrupoInvestigacionCommand,
            FindGrupoInvestigacionQuery findGrupoInvestigacionQuery,
            DeleteGrupoInvestigacionCommand deleteGrupoInvestigacionCommand,
            FindGrupoInvestigacionByIdQuery findGrupoInvestigacionByIdQuery,
            EditGrupoInvestigacionCommand editGrupoInvestigacionCommand
    ) {
        _createGrupoInvestigacionCommand = createGrupoInvestigacionCommand;
        _findGrupoInvestigacionQuery = findGrupoInvestigacionQuery;
        _deleteGrupoInvestigacionCommand = deleteGrupoInvestigacionCommand;
        _findGrupoInvestigacionByIdQuery = findGrupoInvestigacionByIdQuery;
        _editGrupoInvestigacionCommand = editGrupoInvestigacionCommand;
    }

    @PostMapping("/create")
    private Mono<GrupoInvestigacionDto> createGrupoInvestigacion(@RequestBody GrupoInvestigacionDto grupoInvestigacionDto) {
        return _createGrupoInvestigacionCommand.CreateGrupoInvestigacion(grupoInvestigacionDto);
    }

    @PutMapping("/edit/{nombre}/{codigo}")
    private Mono<GrupoInvestigacionDto> editGrupoInvestigacion(@RequestBody GrupoInvestigacionDto grupoInvestigacionDto, @PathVariable String nombre, @PathVariable String codigo) {
        return _editGrupoInvestigacionCommand.EditGrupoInvestigacion(grupoInvestigacionDto, nombre, codigo);
    }

    @GetMapping("/all")
    private Mono<Page<GrupoInvestigacionDto>> getAllGrupoInvestigacion(@RequestParam long page, @RequestParam long size) {
        return _findGrupoInvestigacionQuery.FindAllGrupoInvestigacion(page, size);
    }

    @DeleteMapping("/delete/{nombre}/{codigo}")
    private Mono<DeleteDto> deleteGrupoInvestigacion(@PathVariable String nombre, @PathVariable String codigo) {
        return _deleteGrupoInvestigacionCommand.deleteGrupoInvestigacion(nombre, codigo);
    }

    @GetMapping("/find/{nombre}/{codigo}")
    private Mono<GrupoInvestigacionDto> findSede(@PathVariable String nombre, @PathVariable String codigo) {
        return _findGrupoInvestigacionByIdQuery.FindGrupoInvestigacionByid(nombre, codigo);
    }
}
