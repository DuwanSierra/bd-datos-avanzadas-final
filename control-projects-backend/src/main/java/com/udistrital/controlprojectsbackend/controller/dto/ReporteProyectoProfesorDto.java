package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReporteProyectoProfesorDto {
    private String codigoGrupo;
    private String nombreGrupo;
    private String codigoProyecto;
    private String nombreProyecto;
    private Long cedulaProfesor;
    private String nombreProfesor;
}
