package com.udistrital.controlprojectsbackend.query.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
import com.udistrital.controlprojectsbackend.mappers.SedeMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.SedeRepository;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindSedeQueryHandler implements FindSedeQuery {
    private final SedeRepository _sedeRepository;
    private final SedeMapper _sedeMapper;
    @Autowired
    public FindSedeQueryHandler(SedeRepository sedeRepository, SedeMapper sedeMapper){
        _sedeRepository = sedeRepository;
        _sedeMapper = sedeMapper;
    }
    public Mono<Page<SedeDto>> FindAllSede(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<SedeEntity> total = _sedeRepository.findAll(pageToFind);
            return total.map(_sedeMapper::sedeEntityToSedeDto);
        });
    }
}
