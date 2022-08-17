package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor", indexes = {
        @Index(name = "idx_cedula_profesor", columnList = "cedulaProfesor")
})
@Data
public class ProfesorEntity {
    @Id
    private Long cedulaProfesor;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre del profesor debe ser alfanúmerico no mayor a 70 carácteres")
    private String nombre;
    @Column(nullable = false)
    private Date experienciaInv;
    @ManyToOne
    @JoinColumn(name = "FK_Id_cargo", nullable = false, foreignKey = @ForeignKey(name = "FK_PROFESOR_CARGO"))
    private CargoEntity cargo;
    @ManyToOne
    @JoinColumn(name = "FK_Nombre_Facultad", nullable = false, foreignKey = @ForeignKey(name = "FK_PROFESOR_FACULTAD"))
    private FacultadEntity facultad;
}
