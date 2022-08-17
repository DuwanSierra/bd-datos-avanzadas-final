package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.controller.dto.ReporteProyectoProfesorDto;
import com.udistrital.controlprojectsbackend.query.reports.ReportsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController()
@RequestMapping("/reports")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportsController {

    private final ReportsQuery _reportsQuery;

    @Autowired
    public ReportsController(ReportsQuery reportsQuery){
        _reportsQuery = reportsQuery;
    }
    @GetMapping("/report-project-by-professor/{cedula}")
    private Mono<List<ReporteProyectoProfesorDto>> findRol(@PathVariable Long cedula) {
        return _reportsQuery.FindProjectsByCedulaReport(cedula);
    }
}
