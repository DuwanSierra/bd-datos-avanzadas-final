package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.SedeMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EditSedeCommandHandler implements EditSedeCommand {
    private final SedeRepository _sedeRepository;
    private final SedeMapper _sedeMapper;

    @Autowired
    public EditSedeCommandHandler( SedeRepository sedeRepository, SedeMapper sedeMapper){
        _sedeRepository = sedeRepository;
        _sedeMapper = sedeMapper;
    }
    @Override
    public Mono<SedeDto> EditSede(SedeDto sedeDto, long id) {
        return Mono.fromCallable(() -> {
            try{
                SedeEntity sedeToEdit = _sedeRepository.findById(id).orElse(null);
                if(sedeToEdit==null){
                    throw new NotFoundException("No se ha encontrado la sede", "SedeNotFound");
                }
                sedeToEdit = _sedeMapper.sedeDtoToSedeEntity(sedeDto);
                sedeToEdit.setIdSede(id);
                sedeToEdit = _sedeRepository.save(sedeToEdit);
                return _sedeMapper.sedeEntityToSedeDto(sedeToEdit);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo editar la sede",e.getMessage());
            }
        });
    }
}
