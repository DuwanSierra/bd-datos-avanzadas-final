package com.udistrital.controlprojectsbackend.command.sede;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateSedeCommandHandler implements CreateSedeCommand {

    private SedeRepository _sedeRepository;

    public CreateSedeCommandHandler(@Autowired SedeRepository sedeRepository){
        _sedeRepository = sedeRepository;
    }
    @Override
    public Mono<SedeDto> CreateSede(SedeDto sedeDto) {
        return Mono.fromCallable(() -> {
            try{
                SedeEntity sede = new SedeEntity(null,sedeDto.getNombre(), sedeDto.getCodigo(), sedeDto.getDireccion(), null);
                sede = _sedeRepository.save(sede);
                sedeDto.setSedeId(sede.getSedeId());
                return sedeDto;
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear la sede",e.getMessage());
            }
        });
    }
}
