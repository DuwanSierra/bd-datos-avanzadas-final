package com.udistrital.controlprojectsbackend.command.rol;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteRolCommandHandler implements DeleteRolCommand {

    private final RolRepository _rolRepository;

    @Autowired
    public DeleteRolCommandHandler(RolRepository rolRepository){
        _rolRepository = rolRepository;
    }

    @Override
    public Mono<DeleteDto> deleteRol(long id) {
        return Mono.fromCallable(() -> {
            try{
                RolEntity rolToDelete = _rolRepository.getReferenceById(id);
                _rolRepository.delete(rolToDelete);
                return new DeleteDto("Se ha borrado el rol con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar el rol",e.getMessage());
            }
        });
    }
}
