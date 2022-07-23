package com.udistrital.controlprojectsbackend.repository.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "area_interes")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AreaInteresEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long area_Id;
    @NotEmpty
    @Column(nullable = false)
    @Size(max = 70, message = "El nombre del área de interés debe ser alfanúmerico no mayor a 70 carácteres")
    private String areaNombre;
}
