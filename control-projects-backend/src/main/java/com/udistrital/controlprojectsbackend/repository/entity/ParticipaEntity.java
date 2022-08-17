package com.udistrital.controlprojectsbackend.repository.entity;

import com.udistrital.controlprojectsbackend.controller.dto.ParticipaDto;
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
@AssociationOverrides({
        @AssociationOverride(name = "cedula_profesor", joinColumns = @JoinColumn(name = "cedula_profesor")),
        @AssociationOverride(name = "codigoGrupo", joinColumns = @JoinColumn(name = "codigoGrupo")),
        @AssociationOverride(name = "nombreGrupo", joinColumns = @JoinColumn(name = "nombreGrupo")),
        @AssociationOverride(name = "codigoProyecto", joinColumns = @JoinColumn(name = "codigoProyecto"))
})
public class ParticipaEntity {
    @EmbeddedId
    ParticipaId participaId;
    @ManyToOne
    @JoinColumn(name = "FK_id_rol", foreignKey = @ForeignKey(name = "FK_PARTICIPA_ROL"))
    private RolEntity rol;
}
