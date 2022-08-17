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
public class ParticipaId implements Serializable {
    @ManyToOne(optional = false)
    @JoinColumn(name = "cedula_profesor", nullable = false, foreignKey = @ForeignKey(name = "FK_PARTICIPA_PROFESOR"))
    private ProfesorEntity profesor;
    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "codigoGrupo", referencedColumnName = "codigoGrupo", nullable = false),
            @JoinColumn(name = "nombreGrupo", referencedColumnName = "nombreGrupo", nullable = false),
            @JoinColumn(name = "codigoProyecto", referencedColumnName = "codigoProyecto", nullable = false),
    }, foreignKey = @ForeignKey(name = "FK_PARTICIPA_PROYECTO"))
    private ProyectoInvestigacionEntity proyecto;
}
