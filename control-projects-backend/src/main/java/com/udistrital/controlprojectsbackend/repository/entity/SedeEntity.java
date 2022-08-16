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
        @Index(name = "idx_sede_id", columnList = "sede")
})
@Data
public class SedeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idSede;
    @NotEmpty
    @Size(max = 70, message = "El nombre de la sede debe ser alfanúmerico no mayor a 70 carácteres")
    private String sede;
}
