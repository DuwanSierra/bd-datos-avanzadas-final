package com.udistrital.controlprojectsbackend.query.sede;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindSedeByIdQueryHandler implements FindSedeByIdQuery {

    private SedeRepository _sedeRepository;

    public FindSedeByIdQueryHandler(@Autowired SedeRepository sedeRepository){
        _sedeRepository = sedeRepository;
    }

    @Override
    public Mono<SedeDto> FindSedeById(long id) {
        return Mono.fromCallable(() -> {
            SedeEntity sede = _sedeRepository.findById(id).orElse(null);
            if(sede==null){
                throw new NotFoundException("No se ha encontrado la sede", "SedeNotFound");
            }
            SedeDto sedeDto = new SedeDto();
            sedeDto.setSedeId(sede.getSedeId());
            sedeDto.setNombre(sede.getNombre());
            sedeDto.setCodigo(sede.getCodigo());
            sedeDto.setDireccion(sede.getDireccion());
            return sedeDto;
        });
    }
}
