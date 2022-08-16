package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ProyectoInvestigacionId implements Serializable {
    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "codigoGrupo", referencedColumnName = "codigoGrupo", nullable = false),
            @JoinColumn(name = "nombreGrupo", referencedColumnName = "nombreGrupo", nullable = false)
    }, foreignKey = @ForeignKey(name = "FK_PROYECTO_INVESTIGACION_GRUPO"))
    private GrupoInvestigacionEntity grupoInvestigacion;
    private String codigoProyecto;
}
