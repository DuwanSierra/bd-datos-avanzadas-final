package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesorDto {
    public Long cedulaProfesor;
    private String nombreProfesor;
    private Date inicioInvestigacion;
    private GrupoInvestigacionDto grupoInvestigacion;
}
