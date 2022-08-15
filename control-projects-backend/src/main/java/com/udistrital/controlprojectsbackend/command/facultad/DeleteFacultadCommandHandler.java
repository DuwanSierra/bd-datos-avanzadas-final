package com.udistrital.controlprojectsbackend.command.facultad;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteFacultadCommandHandler implements DeleteFacultadCommand {

    private final FacultadRepository _facultadRepository;

    public DeleteFacultadCommandHandler(@Autowired FacultadRepository facultadRepository){
        _facultadRepository = facultadRepository;
    }

    @Override
    public Mono<DeleteDto> deleteFacultad(String id) {
        return Mono.fromCallable(() -> {
            try{
                FacultadEntity facultadToDelete = _facultadRepository.getReferenceById(id);
                _facultadRepository.delete(facultadToDelete);
                return new DeleteDto("Se ha borrado la facultad con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar la facultad",e.getMessage());
            }
        });
    }
}
