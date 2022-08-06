package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "titulo_profesor", indexes = {
        @Index(name = "idx_titulo_id", columnList = "tituloId")
})
@Data
public class TituloEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tituloId;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre de la sede debe ser alfanúmerico no mayor a 70 carácteres")
    private String nombreTitulo;
    @ManyToOne
    @JoinColumn(name="profesorCedula", nullable=false)
    private ProfesorEntity profesor;
}
