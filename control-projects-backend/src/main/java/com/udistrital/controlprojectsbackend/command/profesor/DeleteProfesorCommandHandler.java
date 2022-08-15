package com.udistrital.controlprojectsbackend.command.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity.FacultadEntity;
import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.FacultadRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProfesorCommandHandler implements DeleteProfesorCommand {

    private final ProfesorRepository _profesorReposiroty;

    public DeleteProfesorCommandHandler(@Autowired ProfesorRepository profesorReposiroty){
        _profesorReposiroty = profesorReposiroty;
    }

    @Override
    public Mono<DeleteDto> deleteProfesor(Long id) {
        return Mono.fromCallable(() -> {
            try{
                ProfesorEntity profesorToDelete = _profesorReposiroty.getReferenceById(id);
                _profesorReposiroty.delete(profesorToDelete);
                return new DeleteDto("Se ha borrado el profesor con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar el profesor",e.getMessage());
            }
        });
    }
}
