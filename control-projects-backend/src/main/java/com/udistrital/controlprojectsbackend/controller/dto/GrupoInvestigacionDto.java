package com.udistrital.controlprojectsbackend.controller.dto;

import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GrupoInvestigacionDto {
    public FactultadDto facultad;
    private String nombreGrupoInvestigacion;
    private Long codigoGrupoInvestigacion;
    private AreaInteresDto areaInteres;
}
