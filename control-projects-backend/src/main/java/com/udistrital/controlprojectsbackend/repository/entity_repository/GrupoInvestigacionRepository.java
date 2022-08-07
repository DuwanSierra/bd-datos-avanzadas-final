package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionEntity;
import com.udistrital.controlprojectsbackend.repository.entity.GrupoInvestigacionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoInvestigacionRepository extends JpaRepository<GrupoInvestigacionEntity, GrupoInvestigacionId> {
}
