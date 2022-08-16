package com.udistrital.controlprojectsbackend.query.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.mappers.SedeMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindSedeByIdQueryHandler implements FindSedeByIdQuery {

    private final SedeRepository _sedeRepository;
    private final SedeMapper _sedeMapper;

    @Autowired
    public FindSedeByIdQueryHandler(SedeRepository sedeRepository, SedeMapper sedeMapper){
        _sedeRepository = sedeRepository;
        _sedeMapper = sedeMapper;
    }

    @Override
    public Mono<SedeDto> FindSedeById(long id) {
        return Mono.fromCallable(() -> {
            SedeEntity sede = _sedeRepository.findById(id).orElse(null);
            if(sede==null){
                throw new NotFoundException("No se ha encontrado la sede", "SedeNotFound");
            }
            return _sedeMapper.sedeEntityToSedeDto(sede);
        });
    }
}
