package com.udistrital.controlprojectsbackend.query.area;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.mappers.AreaInteresMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.data.domain.Pageable;

@Service
public class FindAreaInteresQueryHandler implements  FindAreaInteresQuery {
    private final AreaInteresRepository _areaInteresRepository;
    private final AreaInteresMapper _areaInteresMapper;
    @Autowired
    public FindAreaInteresQueryHandler( AreaInteresRepository areaInteresRepository, AreaInteresMapper areaInteresMapper){
        _areaInteresRepository = areaInteresRepository;
        _areaInteresMapper = areaInteresMapper;
    }

    public Mono<Page<AreaInteresDto>> FindAllAreaInteres(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<AreaInteresEntity> total = _areaInteresRepository.findAll(pageToFind);
            Page<AreaInteresDto> result = total.map(_areaInteresMapper::areaInteresEntityToAreaInteresDto);
            return result;
        });
    }
}
