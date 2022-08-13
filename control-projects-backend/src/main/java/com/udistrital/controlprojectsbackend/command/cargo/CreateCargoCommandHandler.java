package com.udistrital.controlprojectsbackend.command.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateCargoCommandHandler implements CreateCargoCommand {
    private final CargoRepository _cargoRepository;
    private final CargoMapper _cargoMapper;
    @Autowired
    public CreateCargoCommandHandler(CargoRepository cargoRepository, CargoMapper cargoMapper){
        _cargoRepository = cargoRepository;
        _cargoMapper = cargoMapper;
    }
    @Override
    public Mono<CargoDto> CreateCargo(CargoDto cargoDto) {
        return Mono.fromCallable(() -> {
            try {
                CargoEntity cargoEntity = _cargoMapper.cargoDtoToCargoEntity(cargoDto);
                cargoEntity.setIdCargo(null);
                cargoEntity = _cargoRepository.save(cargoEntity);
                return _cargoMapper.cargoEntityToCargoDto(cargoEntity);
            } catch (Exception e) {
                throw new ConflictException("No se pudo crear el cargo", e.getMessage());
            }
        });
    }
}
