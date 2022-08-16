package com.udistrital.controlprojectsbackend.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "facultad", indexes = {
        @Index(name = "idx_facultad_nombre", columnList = "nombreFacultad")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultadEntity {
    @Id
    private String nombreFacultad;
    @ManyToOne
    @JoinColumn(name="FK_Id_Sede", nullable=false, foreignKey = @ForeignKey(name = "FK_FACULTAD_SEDE"))
    private SedeEntity sede;
}
