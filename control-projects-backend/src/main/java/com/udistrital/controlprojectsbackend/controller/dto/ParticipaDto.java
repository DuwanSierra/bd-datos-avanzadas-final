package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParticipaDto {
    private ProfesorDto profesor;
    private ProyectoInvestigacionDto proyecto;
    private RolDto rol;
}
