package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "telefono", indexes = {
        @Index(name = "idx_telefono_facultad", columnList = "nombre_facultad"),
        @Index(name = "idx_telefono_telefono", columnList = "telefono"),
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(TelefonoId.class)
public class TelefonoEntity {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "nombre_facultad", nullable = false, foreignKey =  @ForeignKey(name = "FK_TELEFONO_FACULTAD"))
    public FacultadEntity facultad;
    @Id
    private String telefono;
}
