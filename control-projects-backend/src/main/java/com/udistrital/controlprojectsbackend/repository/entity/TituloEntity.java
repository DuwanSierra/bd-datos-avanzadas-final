package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "titulo", indexes = {
        @Index(name = "idx_titulo_id", columnList = "titulo"),
        @Index(name = "idx_profesor_id", columnList = "cedula_profesor")
})
@Data
@IdClass(TituloId.class)
public class TituloEntity {
    @Id
    @Size(max = 70, message = "El nombre de la sede debe ser alfanúmerico no mayor a 70 carácteres")
    private String titulo;
    @Id
    @ManyToOne
    @JoinColumn(name="cedula_profesor", nullable=false, foreignKey = @ForeignKey(name = "FK_TITULO_PROFESOR"))
    private ProfesorEntity profesor;
}
