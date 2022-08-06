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
@Table(name = "sede", indexes = {
        @Index(name = "idx_sede_id", columnList = "sedeId")
})
@Data
public class SedeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long sedeId;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre de la sede debe ser alfanúmerico no mayor a 70 carácteres")
    private String nombre;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 10, message = "El código de la sede debe ser alfanúmerico no mayor a 10 carácteres")
    private String codigo;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 30, message = "La dirección de la sede debe ser alfanúmerico no mayor a 30 carácteres")
    private String direccion;
    @OneToMany(mappedBy="sede")
    private Set<FacultadEntity> facultadEntities;
}
