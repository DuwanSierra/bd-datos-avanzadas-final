package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participa", indexes = {
        @Index(name = "idx_profesor_participa_id", columnList = "cedula_profesor"),
        @Index(name = "idx_codigoProyecto_participa_id", columnList = "codigoProyecto"),
        @Index(name = "idx_nombreGrupo_participa_id", columnList = "nombreGrupo"),
        @Index(name = "idx_codigoGrupo_participa_id", columnList = "codigoGrupo"),
})
@Data
@IdClass(ParticipaId.class)
public class ParticipaEntity {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "cedula_profesor", nullable = false, foreignKey = @ForeignKey(name = "FK_PARTICIPA_PROFESOR"))
    private ProfesorEntity profesor;
    @Id
    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(name = "codigoGrupo", referencedColumnName = "codigoGrupo", nullable = false),
            @JoinColumn(name = "nombreGrupo", referencedColumnName = "nombreGrupo", nullable = false),
            @JoinColumn(name = "codigoProyecto", referencedColumnName = "codigoProyecto", nullable = false),
    }, foreignKey = @ForeignKey(name = "FK_PARTICIPA_PROYECTO"))
    private ProyectoInvestigacionEntity proyecto;
    @ManyToOne
    @JoinColumn(name = "FK_id_rol", foreignKey = @ForeignKey(name = "FK_PARTICIPA_ROL"))
    private RolEntity rol;
}
