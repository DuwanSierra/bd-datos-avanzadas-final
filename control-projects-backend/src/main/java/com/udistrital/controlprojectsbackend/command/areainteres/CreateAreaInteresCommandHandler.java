package com.udistrital.controlprojectsbackend.command.areainteres;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.exceptions.ConflictException;
import com.udistrital.controlprojectsbackend.mappers.AreaInteresMapper;
import com.udistrital.controlprojectsbackend.repository.entity_repository.AreaInteresRepository;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateAreaInteresCommandHandler implements CreateAreaInteresCommand {

    private final AreaInteresRepository _areaInteresRepository;
    private final AreaInteresMapper _areaInteresMapper;
    @Autowired
    public CreateAreaInteresCommandHandler(AreaInteresRepository areaInteresRepository, AreaInteresMapper areaInteresMapper){
        _areaInteresRepository = areaInteresRepository;
        _areaInteresMapper = areaInteresMapper;
    }
    @Override
    public Mono<AreaInteresDto> CreateAreaInteres(AreaInteresDto areaInteresDto) {
        return Mono.fromCallable(() -> {
            try{
                AreaInteresEntity areaInteresEntity = _areaInteresMapper.areaInteresDtoToAreaInteresEntity(areaInteresDto);
                areaInteresEntity.setIdAreaInteres(null);
                areaInteresEntity = _areaInteresRepository.save(areaInteresEntity);
                return _areaInteresMapper.areaInteresEntityToAreaInteresDto(areaInteresEntity);
            }
            catch (Exception e){
                throw new ConflictException("No se pudo crear el área de interés",e.getMessage());
            }
        });
    }
}
