package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.ProyectoInvestigacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoInvestigacionRepository extends JpaRepository<ProyectoInvestigacionEntity, Long> {
}
