package com.udistrital.controlprojectsbackend.query.cargo;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.SedeEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindCargoQueryHandler implements FindCargoQuery {
    private final CargoMapper _cargoMapper;
    private final CargoRepository _cargoRepository;
    @Autowired
    public FindCargoQueryHandler(CargoMapper cargoMapper, CargoRepository cargoRepository){
        _cargoMapper = cargoMapper;
        _cargoRepository = cargoRepository;
    }
    @Override
    public Mono<Page<CargoDto>> FindAllCargos(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<CargoEntity> total = _cargoRepository.findAll(pageToFind);
            return total.map(_cargoMapper::cargoEntityToCargoDto);
        });
    }
}
