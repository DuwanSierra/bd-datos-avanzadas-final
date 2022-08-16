package com.udistrital.controlprojectsbackend.query.profesor;

import com.udistrital.controlprojectsbackend.controller.dto.ProfesorDto;
import com.udistrital.controlprojectsbackend.mappers.ProfesorMapper;
import com.udistrital.controlprojectsbackend.repository.entity.ProfesorEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindProfesorQueryHandler implements FindProfesorQuery {
    private final ProfesorRepository _profesorReposiroty;
    private final ProfesorMapper _profesorMapper;

    @Autowired
    public FindProfesorQueryHandler(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper){
        _profesorReposiroty = profesorRepository;
        _profesorMapper = profesorMapper;
    }
    @Override
    public Mono<Page<ProfesorDto>> FindAllProfesor(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<ProfesorEntity> total = _profesorReposiroty.findAll(pageToFind);
            Page<ProfesorDto> result = total.map(_profesorMapper::profesorEntityToProfesorDto);
            return result;
        });
    }
}
