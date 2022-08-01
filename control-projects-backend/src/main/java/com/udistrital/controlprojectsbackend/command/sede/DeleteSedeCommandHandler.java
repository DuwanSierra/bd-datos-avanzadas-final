package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteSedeCommandHandler implements DeleteSedeCommand {

    private SedeRepository _sedeRepository;

    public DeleteSedeCommandHandler(@Autowired SedeRepository sedeRepository){
        _sedeRepository = sedeRepository;
    }
    @Override
    public Mono<DeleteDto> deleteSede(long id) {
        return Mono.fromCallable(() -> {
            try{
                SedeEntity sedeTodelete = _sedeRepository.getReferenceById(id);
                _sedeRepository.delete(sedeTodelete);
                return  new DeleteDto("Se ha borrado la sede con éxito",true);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo borrar la sede",e.getMessage());
            }
        });
    }
}
