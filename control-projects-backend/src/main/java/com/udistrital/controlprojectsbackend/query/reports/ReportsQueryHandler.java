package com.udistrital.controlprojectsbackend.query.reports;

import com.udistrital.controlprojectsbackend.controller.dto.ReporProjectActivesInactivesDto;
import com.udistrital.controlprojectsbackend.controller.dto.ReporteProyectoProfesorDto;
import com.udistrital.controlprojectsbackend.mappers.ReportsMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ReportsProjectStatusRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ReportsRepository;
import com.udistrital.controlprojectsbackend.repository.reports.ReportProjectsActivesInactivesView;
import com.udistrital.controlprojectsbackend.repository.reports.ReporteProyectoProfesorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportsQueryHandler implements ReportsQuery {
    private final ReportsRepository _reportsRepository;
    private final ReportsProjectStatusRepository _reportsProjectStatusRepository;
    private final ReportsMapper _reportsMapper;

    @Autowired
    public ReportsQueryHandler(ReportsRepository reportsRepository, ReportsMapper reportsMapper, ReportsProjectStatusRepository reportsProjectStatusRepository){
        _reportsRepository = reportsRepository;
        _reportsMapper = reportsMapper;
        _reportsProjectStatusRepository = reportsProjectStatusRepository;
    }
    @Override
    public Mono<List<ReporteProyectoProfesorDto>> FindProjectsByCedulaReport(Long cedula) {
        return Mono.fromCallable(() -> {
            List<ReporteProyectoProfesorView> reportResult = _reportsRepository.FindAllProjectsByProfessor(cedula);
            return reportResult.stream().map(_reportsMapper::convertReporteProyectoProfesorViewToReporteProyectoProfesorDto).collect(Collectors.toList());
        });
    }

    @Override
    public Mono<List<ReporProjectActivesInactivesDto>> FindProjectsActivesInactives() {
        return Mono.fromCallable(() -> {
            List<ReportProjectsActivesInactivesView> reportResult = _reportsProjectStatusRepository.FindAllProjectsActiveInactive();
            return reportResult.stream().map(_reportsMapper::convertReportProjectActiveInactive).collect(Collectors.toList());
        });
    }
}
