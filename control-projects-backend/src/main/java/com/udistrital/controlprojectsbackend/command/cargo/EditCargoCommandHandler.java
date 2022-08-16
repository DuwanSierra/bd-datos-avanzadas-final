package com.udistrital.controlprojectsbackend.command.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
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
public class EditCargoCommandHandler implements EditCargoCommand {
    private final CargoRepository _cargoRepository;
    private final CargoMapper _cargoMapper;

    @Autowired
    public EditCargoCommandHandler(CargoRepository cargoRepository, CargoMapper cargoMapper){
        _cargoMapper = cargoMapper;
        _cargoRepository = cargoRepository;
    }
    @Override
    public Mono<CargoDto> EditCargo(CargoDto cargoDto, long id) {
        return Mono.fromCallable(() -> {
            try{
                CargoEntity cargoToEdit = _cargoRepository.findById(id).orElse(null);
                if(cargoToEdit==null){
                    throw new NotFoundException("No se ha encontrado el cargo", "CargoNotFound");
                }
                cargoToEdit = _cargoMapper.cargoDtoToCargoEntity(cargoDto);
                cargoToEdit.setIdCargo(id);
                cargoToEdit = _cargoRepository.save(cargoToEdit);
                return _cargoMapper.cargoEntityToCargoDto(cargoToEdit);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo editar el cargo",e.getMessage());
            }
        });
    }
}
