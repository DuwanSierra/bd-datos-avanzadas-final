package com.udistrital.controlprojectsbackend.query.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.AreaInteresMapper;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindCargoByIdQueryHandler implements FindCargoByIdQuery {

    private final CargoRepository _cargoRepository;
    private final CargoMapper _cargoMapper;

    @Autowired
    public FindCargoByIdQueryHandler(CargoRepository cargoRepository, CargoMapper cargoMapper) {
        _cargoRepository = cargoRepository;
        _cargoMapper = cargoMapper;
    }

    @Override
    public Mono<CargoDto> FindCargoById(long id) {
        return Mono.fromCallable(() -> {
            CargoEntity cargoEntity = _cargoRepository.findById(id).orElse(null);
            if (cargoEntity == null) {
                throw new NotFoundException("No se ha encontrado el área de interes", "AreInteresNotFound");
            }
            return _cargoMapper.cargoEntityToCargoDto(cargoEntity);
        });
    }
}
