package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProyectoInvestigacionDto {
    private GrupoInvestigacionDto grupoInvestigacion;
    private String codigo;
    private String nombre;
    private BigDecimal presupuesto;
    private Date fechaInicio;
    private Date fechaTerminacion;
}
