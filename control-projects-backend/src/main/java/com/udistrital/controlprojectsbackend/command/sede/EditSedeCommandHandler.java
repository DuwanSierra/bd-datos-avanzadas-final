package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EditSedeCommandHandler implements EditSedeCommand {
    private SedeRepository _sedeRepository;

    public EditSedeCommandHandler(@Autowired SedeRepository sedeRepository){
        _sedeRepository = sedeRepository;
    }
    @Override
    public Mono<SedeDto> EditSede(SedeDto sedeDto, long id) {
        return Mono.fromCallable(() -> {
            try{
                SedeEntity sedeToEdit = _sedeRepository.findById(id).orElse(null);
                if(sedeToEdit==null){
                    throw new NotFoundException("No se ha encontrado la sede", "SedeNotFound");
                }
                _sedeRepository.save(sedeToEdit);
                return sedeDto;
            }
            catch (Exception e){
                throw new ConflictException("No se pudo editar la sede",e.getMessage());
            }
        });
    }
}
