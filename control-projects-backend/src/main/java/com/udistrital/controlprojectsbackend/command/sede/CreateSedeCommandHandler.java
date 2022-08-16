package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.SedeMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateSedeCommandHandler implements CreateSedeCommand {

    private SedeRepository _sedeRepository;
    private final SedeMapper _sedeMapper;

    @Autowired
    public CreateSedeCommandHandler(SedeRepository sedeRepository, SedeMapper sedeMapper){
        _sedeRepository = sedeRepository;
        _sedeMapper = sedeMapper;
    }
    @Override
    public Mono<SedeDto> CreateSede(SedeDto sedeDto) {
        return Mono.fromCallable(() -> {
            try {
                SedeEntity sede = _sedeMapper.sedeDtoToSedeEntity(sedeDto);
                sede.setIdSede(null);
                sede = _sedeRepository.save(sede);
                return _sedeMapper.sedeEntityToSedeDto(sede);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear la sede",e.getMessage());
            }
        });
    }
}
