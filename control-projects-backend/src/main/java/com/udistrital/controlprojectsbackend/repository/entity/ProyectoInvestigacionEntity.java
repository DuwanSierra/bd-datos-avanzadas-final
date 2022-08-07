package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyecto_investigacion", indexes = {
        @Index(name = "idx_codigo_proyecto", columnList = "proyectoId")
})
@Data
public class ProyectoInvestigacionEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long proyectoId;
    @NotEmpty
    @Column(nullable = false)
    private String proyectoNombre;
    @NotEmpty
    @Column(nullable = false)
    private Long codigoProyecto;
    @NotEmpty
    @Column(nullable = false)
    private BigDecimal presupuestoProyecto;
    @NotEmpty
    @Column(nullable = false)
    private Date fechaInicioProyecto;
    @NotEmpty
    @Column(nullable = false)
    private Date fechaFinProyecto;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "grupoInvestigacion_facultad_nombre", referencedColumnName = "facultad_nombre"),
            @JoinColumn(name = "grupoInvestigacion_nombreGrupoInvestigacion", referencedColumnName = "nombreGrupoInvestigacion"),
            @JoinColumn(name = "grupoInvestigacion_codigoGrupoInvestigacion", referencedColumnName = "codigoGrupoInvestigacion")
    })
    private GrupoInvestigacionEntity grupoInvestigacion;
}
