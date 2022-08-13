package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.TelefonoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.TelefonoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<TelefonoEntity, TelefonoId> {
}
