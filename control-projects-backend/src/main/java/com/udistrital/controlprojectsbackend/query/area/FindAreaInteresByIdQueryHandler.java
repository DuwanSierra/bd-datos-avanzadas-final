package com.udistrital.controlprojectsbackend.query.area;

import com.udistrital.controlprojectsbackend.exceptions.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.exceptions.NotFoundException;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindAreaInteresByIdQueryHandler implements FindAreaInteresByIdQuery{

    private AreaInteresRepository _areaInteresRepository;

    public FindAreaInteresByIdQueryHandler(@Autowired AreaInteresRepository areaInteresRepository){
        _areaInteresRepository = areaInteresRepository;
    }

    @Override
    public Mono<AreaInteresDto> FindAreaInteresById(long id) {
        return Mono.fromCallable(() -> {
            AreaInteresEntity areaInteresEntity = _areaInteresRepository.findById(id).orElse(null);
            if(areaInteresEntity==null){
                throw new NotFoundException("No se ha encontrado el área de interes", "AreInteresNotFound");
            }
           AreaInteresDto areaInteresDto = new AreaInteresDto(areaInteresEntity.getAreaId(), areaInteresEntity.getAreaNombre());
            return areaInteresDto;
        });
    }
}
