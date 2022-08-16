package com.udistrital.controlprojectsbackend.query.rol;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.RolDto;
import com.udistrital.controlprojectsbackend.mappers.CargoMapper;
import com.udistrital.controlprojectsbackend.mappers.RolMapper;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import com.udistrital.controlprojectsbackend.repository.entity.RolEntity;
import com.udistrital.controlprojectsbackend.repository.entity_repository.CargoRepository;
import com.udistrital.controlprojectsbackend.repository.entity_repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindRolQueryHandler implements FindRolQuery {
    private final RolRepository _rolRepository;
    private final RolMapper _rolMapper;
    @Autowired
    public FindRolQueryHandler(RolRepository rolRepository, RolMapper rolMapper){
        _rolRepository = rolRepository;
        _rolMapper = rolMapper;
    }
    @Override
    public Mono<Page<RolDto>> FindAllRol(long page, long size) {
        return Mono.fromCallable(() -> {
            Pageable pageToFind = PageRequest.of(Integer.parseInt(String.valueOf(page)), Integer.parseInt(String.valueOf(size)));
            Page<RolEntity> total = _rolRepository.findAll(pageToFind);
            return total.map(_rolMapper::rolEntityToRolDto);
        });
    }
}
