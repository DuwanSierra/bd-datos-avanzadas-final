package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyecto_investigacion", indexes = {
        @Index(name = "idx_grupo_proyecto_Id", columnList = "codigoGrupo"),
        @Index(name = "idx_grupo_nombre_proyecto_Id", columnList = "nombreGrupo"),
        //@Index(name = "idx_proyecto_Id", columnList = "codigoProyecto")
})
@Data
@AssociationOverrides({
        @AssociationOverride(name = "codigoGrupo", joinColumns = @JoinColumn(name = "nombreGrupo")),
        @AssociationOverride(name = "nombreGrupo", joinColumns = @JoinColumn(name = "nombreGrupo"))
})
public class ProyectoInvestigacionEntity {
    @EmbeddedId
    private ProyectoInvestigacionId proyectoInvestigacionId;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre del proyecto debe ser alfanúmerico no mayor a 70 carácteres")
    private String nombre;
    @Column(nullable = false)
    private BigDecimal valorPres;
    @Column(nullable = false)
    private Date fechaInicio;
    @Column(nullable = false)
    private Date fechaTerminacion;
}
