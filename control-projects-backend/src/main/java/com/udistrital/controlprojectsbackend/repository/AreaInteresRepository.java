package com.udistrital.controlprojectsbackend.repository;

import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaInteresRepository extends JpaRepository<AreaInteresEntity, Long> {
}
