package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProyectoInvestigacionId implements Serializable {
    private GrupoInvestigacionEntity grupoInvestigacion;
    private String codigoProyecto;
}
