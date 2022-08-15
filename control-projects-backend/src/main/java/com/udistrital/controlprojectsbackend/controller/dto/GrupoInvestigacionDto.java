package com.udistrital.controlprojectsbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GrupoInvestigacionDto {
    public FacultadDto facultad;
    private String nombreGrupoInvestigacion;
    private Long codigoGrupoInvestigacion;
    private AreaInteresDto areaInteres;
    private ProfesorDto profesor;
}
