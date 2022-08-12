package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo", indexes = {
        @Index(name = "idx_cargo_id", columnList = "idCargo")
})
@Data
public class CargoEntity {
    @Id
    private Long idCargo;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre del profesor debe ser alfanúmerico no mayor a 70 carácteres")
    private String cargo;
}
