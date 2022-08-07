package com.udistrital.controlprojectsbackend.query.sede;

import com.udistrital.controlprojectsbackend.controller.dto.SedeDto;
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
    private SedeRepository _sedeRepository;

    public FindSedeQueryHandler(@Autowired SedeRepository sedeRepository){
        _sedeRepository = sedeRepository;
    }
    public Mono<Page<SedeDto>> FindAllSede(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<SedeEntity> total = _sedeRepository.findAll(pageToFind);
            Page<SedeDto> result = total.map(this::convertToObjectDto);
            return result;
        });
    }
    private SedeDto convertToObjectDto(SedeEntity input) {
        SedeDto dto = new SedeDto();
        dto.setSedeId(input.getSedeId());
        dto.setNombre(input.getNombre());
        dto.setCodigo(input.getCodigo());
        dto.setDireccion(input.getDireccion());
        return dto;
    }
}
