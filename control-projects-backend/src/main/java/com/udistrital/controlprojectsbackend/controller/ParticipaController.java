package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.participa.CreateParticipaCommand;
import com.udistrital.controlprojectsbackend.command.participa.DeleteParticipaCommand;
import com.udistrital.controlprojectsbackend.command.participa.EditParticipaCommand;
import com.udistrital.controlprojectsbackend.command.profesor.CreateProfesorCommand;
import com.udistrital.controlprojectsbackend.command.profesor.DeleteProfesorCommand;
import com.udistrital.controlprojectsbackend.command.profesor.EditProfesorCommand;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.query.participa.FindParticipaByIdQuery;
import com.udistrital.controlprojectsbackend.query.participa.FindParticipaQuery;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorByIdQuery;
import com.udistrital.controlprojectsbackend.query.profesor.FindProfesorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/participa")
@CrossOrigin(origins = "http://localhost:4200")
public class ParticipaController {
    private final FindParticipaQuery _findParticipaQuery;
    private final CreateParticipaCommand _createParticipaCommand;
    private final DeleteParticipaCommand _deleteParticipaCommand;
    private final EditParticipaCommand _editParticipaCommand;
    private final FindParticipaByIdQuery _findParticipaByIdQuery;

    @Autowired
    public ParticipaController(FindParticipaQuery findParticipaQuery,
                               CreateParticipaCommand createParticipaCommand,
                               DeleteParticipaCommand deleteParticipaCommand,
                               EditParticipaCommand editParticipaCommand,
                               FindParticipaByIdQuery findParticipaByIdQuery
    ) {
        _findParticipaQuery = findParticipaQuery;
        _createParticipaCommand = createParticipaCommand;
        _deleteParticipaCommand = deleteParticipaCommand;
        _editParticipaCommand = editParticipaCommand;
        _findParticipaByIdQuery = findParticipaByIdQuery;
    }

    @GetMapping("/all")
    private Mono<Page<ParticipaDto>> getAllProfesor(
            @RequestParam long page,
            @RequestParam long size,
            @RequestParam(required = false) String nombreGrupo,
            @RequestParam(required = false) String codigoGrupo,
            @RequestParam(required = false) String codigoProyecto
    ) {
        return _findParticipaQuery.FindAllParticipa(page, size, nombreGrupo, codigoGrupo, codigoProyecto);
    }

    @PostMapping("/create")
    private Mono<ParticipaDto> createProfesor(@RequestBody ParticipaDto participaDto) {
        return _createParticipaCommand.CreateParticipa(participaDto);
    }

    @PutMapping("/edit/{nombreGrupo}/{codigoGrupo}/{codigoProyecto}/{cedulaProfesor}")
    private Mono<ParticipaDto> editRol(
            @RequestBody ParticipaDto participaDto,
            @PathVariable String nombreGrupo,
            @PathVariable String codigoGrupo,
            @PathVariable String codigoProyecto,
            @PathVariable Long cedulaProfesor
    ) {
        return _editParticipaCommand.EditParticipa(participaDto, nombreGrupo, codigoGrupo, codigoProyecto, cedulaProfesor);
    }

    @DeleteMapping("/delete/{nombreGrupo}/{codigoGrupo}/{codigoProyecto}/{cedulaProfesor}")
    private Mono<DeleteDto> deleteRol(
            @PathVariable String nombreGrupo,
            @PathVariable String codigoGrupo,
            @PathVariable String codigoProyecto,
            @PathVariable Long cedulaProfesor) {
        return _deleteParticipaCommand.deleteParticipa(nombreGrupo, codigoGrupo, codigoProyecto, cedulaProfesor);
    }

    @GetMapping("/find/{nombreGrupo}/{codigoGrupo}/{codigoProyecto}/{cedulaProfesor}")
    private Mono<ParticipaDto> findRol(
            @PathVariable String nombreGrupo,
            @PathVariable String codigoGrupo,
            @PathVariable String codigoProyecto,
            @PathVariable Long cedulaProfesor
    ) {
        return _findParticipaByIdQuery.FindParticipaByid(nombreGrupo, codigoGrupo, codigoProyecto, cedulaProfesor);
    }
}
