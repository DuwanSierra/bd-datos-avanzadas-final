package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteFacultadCommandHandler implements DeleteFacultadCommand {

    private final CargoRepository _cargoRepository;

    public DeleteFacultadCommandHandler(@Autowired CargoRepository cargoRepository){
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
