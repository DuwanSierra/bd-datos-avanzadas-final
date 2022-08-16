package com.udistrital.controlprojectsbackend.command.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteCargoCommandHandler implements DeleteCargoCommand {

    private final CargoRepository _cargoRepository;

    public DeleteCargoCommandHandler(@Autowired CargoRepository cargoRepository){
        _cargoRepository = cargoRepository;
    }

    @Override
    public Mono<DeleteDto> deleteCargo(long id) {
        return Mono.fromCallable(() -> {
            try{
                CargoEntity cargoToDelete = _cargoRepository.getReferenceById(id);
                _cargoRepository.delete(cargoToDelete);
                return  new DeleteDto("Se ha borrado el cargo con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar el cargo",e.getMessage());
            }
        });
    }
}
