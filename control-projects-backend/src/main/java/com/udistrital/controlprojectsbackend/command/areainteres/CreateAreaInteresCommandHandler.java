package com.udistrital.controlprojectsbackend.command.areainteres;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateAreaInteresCommandHandler implements CreateAreaInteresCommand {

    private AreaInteresRepository _areaInteresRepository;

    public CreateAreaInteresCommandHandler(@Autowired AreaInteresRepository areaInteresRepository){
        _areaInteresRepository = areaInteresRepository;
    }
    @Override
    public Mono<AreaInteresDto> CreateAreaInteres(AreaInteresDto areaInteresDto) {
        return Mono.fromCallable(() -> {
            try{
                AreaInteresEntity areaInteresEntity = new AreaInteresEntity(null,areaInteresDto.getAreaNombre());
                areaInteresEntity = _areaInteresRepository.save(areaInteresEntity);
                return areaInteresDto;
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear el área de interés",e.getMessage());
            }
        });
    }
}
