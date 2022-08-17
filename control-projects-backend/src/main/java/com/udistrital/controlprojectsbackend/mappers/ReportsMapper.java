package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.ReporProjectActivesInactivesDto;
import com.udistrital.controlprojectsbackend.controller.dto.ReporteProyectoProfesorDto;
import com.udistrital.controlprojectsbackend.repository.reports.ReportProjectsActivesInactivesView;
import com.udistrital.controlprojectsbackend.repository.reports.ReporteProyectoProfesorView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ReportsMapper {
    @Mapping(target = "codigoGrupo", source = "codigogrupo")
    @Mapping(target = "nombreGrupo", source = "nombregrupo")
    @Mapping(target = "codigoProyecto", source = "codigoproyecto")
    @Mapping(target = "cedulaProfesor", source = "cedulaprofesor")
    @Mapping(target = "nombreProfesor", source = "nombreprofesor")
    @Mapping(target = "nombreProyecto", source = "nombreproyecto")
    public abstract ReporteProyectoProfesorDto convertReporteProyectoProfesorViewToReporteProyectoProfesorDto(ReporteProyectoProfesorView reporteProyectoProfesorView);
    @Mapping(target = "codigoproyecto", source = "codigoproyecto")
    @Mapping(target = "nombreproyecto", source = "nombreproyecto")
    @Mapping(target = "fechainicio", source = "fechainicio")
    @Mapping(target = "fechaterminacion", source = "fechaterminacion")
    @Mapping(target = "estado", source = "estado")
    public abstract ReporProjectActivesInactivesDto convertReportProjectActiveInactive(ReportProjectsActivesInactivesView reportProjectsActivesInactivesView);
}
