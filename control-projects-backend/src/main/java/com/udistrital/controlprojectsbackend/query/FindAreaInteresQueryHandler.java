package com.udistrital.controlprojectsbackend.query;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.data.domain.Pageable;

@Service
public class FindAreaInteresQueryHandler implements  FindAreaInteresQuery {
    private AreaInteresRepository _areaInteresRepository;
    public FindAreaInteresQueryHandler(@Autowired AreaInteresRepository areaInteresRepository){
        _areaInteresRepository = areaInteresRepository;
    }

    public Mono<Page<AreaInteresDto>> FindAllAreaInteres(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<AreaInteresEntity> total = _areaInteresRepository.findAll(pageToFind);
            Page<AreaInteresDto> result = total.map(this::convertToObjectDto);
            return result;
        });
    }

    private AreaInteresDto convertToObjectDto(AreaInteresEntity input) {
        AreaInteresDto dto = new AreaInteresDto();
        dto.setAreaId(input.getArea_Id());
        dto.setAreaNombre(input.getAreaNombre());
        return dto;
    }
}
