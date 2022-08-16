package com.udistrital.controlprojectsbackend.repository.entity_repository;

import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity,Long> {
}
