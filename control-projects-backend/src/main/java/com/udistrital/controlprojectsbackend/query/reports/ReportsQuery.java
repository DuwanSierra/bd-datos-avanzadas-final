package com.udistrital.controlprojectsbackend.query.reports;

import com.udistrital.controlprojectsbackend.controller.dto.ReporteProyectoProfesorDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface ReportsQuery {
    Mono<List<ReporteProyectoProfesorDto>> FindProjectsByCedulaReport(Long cedula);
}
