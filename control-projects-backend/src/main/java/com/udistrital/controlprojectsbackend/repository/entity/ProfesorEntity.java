package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor", indexes = {
        @Index(name = "idx_cedula_profesor", columnList = "cedulaProfesor")
})
@Data
public class ProfesorEntity {
    @Id
    public Long cedulaProfesor;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre del profesor debe ser alfanúmerico no mayor a 70 carácteres")
    private String nombreProfesor;
    @NotEmpty
    @Column(nullable = false)
    private Date inicioInvestigacion;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "grupoInvestigacion_facultad_nombre", referencedColumnName = "facultad_nombre"),
            @JoinColumn(name = "grupoInvestigacion_nombreGrupoInvestigacion", referencedColumnName = "nombreGrupoInvestigacion"),
            @JoinColumn(name = "grupoInvestigacion_codigoGrupoInvestigacion", referencedColumnName = "codigoGrupoInvestigacion")
    })
    private GrupoInvestigacionEntity grupoInvestigacion;
}
