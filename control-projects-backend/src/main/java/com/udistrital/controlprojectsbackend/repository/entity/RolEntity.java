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
@Table(name = "rol", indexes = {
        @Index(name = "idx_rol_id", columnList = "rolId")
})
@Data
public class RolEntity {
    @Id
    private Long rolId;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El rol debe ser alfanúmerico no mayor a 70 carácteres")
    private String rol;
}
