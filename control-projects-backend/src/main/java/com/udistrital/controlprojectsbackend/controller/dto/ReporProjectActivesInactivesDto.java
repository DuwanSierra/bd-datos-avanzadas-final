package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReporProjectActivesInactivesDto {
    private String codigoproyecto;
    private String nombreproyecto;
    private Date fechainicio;
    private Date fechaterminacion;
    private String estado;
}
