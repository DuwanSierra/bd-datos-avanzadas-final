package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.grupoinvestigacion.CreateGrupoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.grupoinvestigacion.DeleteGrupoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.grupoinvestigacion.EditGrupoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.proyectoinvestigacion.CreateProyectoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.proyectoinvestigacion.DeleteProyectoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.command.proyectoinvestigacion.EditProyectoInvestigacionCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.GrupoInvestigacionDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProyectoInvestigacionDto;
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.query.grupoinvestigacion.FindGrupoInvestigacionQuery;
import com.udistrital.controlprojectsbackend.query.proyectoinvestigacion.FindProyectoInvestigacionByIdQuery;
import com.udistrital.controlprojectsbackend.query.proyectoinvestigacion.FindProyectoInvestigacionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/proyecto-investigacion")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoInvestigacionController {
    private CreateProyectoInvestigacionCommand _createProyectoInvestigacionCommand;
    private FindProyectoInvestigacionQuery _findProyectoInvestigacionQuery;
    private DeleteProyectoInvestigacionCommand _deleteProyectoInvestigacionCommand;
    private FindProyectoInvestigacionByIdQuery _findProyectoInvestigacionByIdQuery;
    private EditProyectoInvestigacionCommand _editProyectoInvestigacionCommand;

    @Autowired
    public ProyectoInvestigacionController(
            CreateProyectoInvestigacionCommand createProyectoInvestigacionCommand,
            FindProyectoInvestigacionQuery findProyectoInvestigacionQuery,
            DeleteProyectoInvestigacionCommand deleteProyectoInvestigacionCommand,
            FindProyectoInvestigacionByIdQuery findProyectoInvestigacionByIdQuery,
            EditProyectoInvestigacionCommand editProyectoInvestigacionCommand
    ) {
        _createProyectoInvestigacionCommand = createProyectoInvestigacionCommand;
        _findProyectoInvestigacionQuery = findProyectoInvestigacionQuery;
        _deleteProyectoInvestigacionCommand = deleteProyectoInvestigacionCommand;
        _findProyectoInvestigacionByIdQuery = findProyectoInvestigacionByIdQuery;
        _editProyectoInvestigacionCommand = editProyectoInvestigacionCommand;
    }

    @PostMapping("/create")
    private Mono<ProyectoInvestigacionDto> createProyectoInvestigacion(@RequestBody ProyectoInvestigacionDto proyectoInvestigacionDto) {
        return _createProyectoInvestigacionCommand.CreateProyectoInvestigacion(proyectoInvestigacionDto);
    }

    @PutMapping("/edit/{nombreGrupo}/{codigoGrupo}/{codigoProyecto}")
    private Mono<ProyectoInvestigacionDto> editProyectoInvestigacion(@RequestBody ProyectoInvestigacionDto proyectoInvestigacionDto, @PathVariable String nombreGrupo, @PathVariable String codigoGrupo, @PathVariable String codigo) {
        return _editProyectoInvestigacionCommand.EditProyectoInvestigacion(proyectoInvestigacionDto, nombreGrupo, codigoGrupo, codigo);
    }

    @GetMapping("/all")
    private Mono<Page<ProyectoInvestigacionDto>> getAllProyectoInvestigacion(@RequestParam long page, @RequestParam long size) {
        return _findProyectoInvestigacionQuery.FindAllProyectoInvestigacion(page, size);
    }

    @DeleteMapping("/delete/{nombreGrupo}/{codigoGrupo}/{codigoProyecto}")
    private Mono<DeleteDto> deleteGrupoInvestigacion(@PathVariable String nombreGrupo,@PathVariable String codigoGrupo , @PathVariable String codigo) {
        return _deleteProyectoInvestigacionCommand.deleteProyectoInvestigacion(nombreGrupo, codigoGrupo, codigo);
    }

    @GetMapping("/find/{nombreGrupo}/{codigoGrupo}/{codigoProyecto}")
    private Mono<ProyectoInvestigacionDto> findGrupoInvestigacion(@PathVariable String nombreGrupo,@PathVariable String codigoGrupo , @PathVariable String codigo) {
        return _findProyectoInvestigacionByIdQuery.FindProyectoInvestigacionByid(nombreGrupo, codigoGrupo, codigo);
    }
}
