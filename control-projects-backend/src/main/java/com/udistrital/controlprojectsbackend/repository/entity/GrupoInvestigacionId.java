package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GrupoInvestigacionId implements Serializable {
    private FacultadEntity facultad;
    private String nombreGrupoInvestigacion;
    private Long codigoGrupoInvestigacion;
}
