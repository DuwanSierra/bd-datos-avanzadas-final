package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.repository.entity.AreaInteresEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AreaInteresMapper {
    @Mapping(target = "areaId", source = "idAreaInteres")
    @Mapping(target = "areaNombre", source = "areaInteres")
    public abstract AreaInteresDto areaInteresEntityToAreaInteresDto(AreaInteresEntity areaInteresEntity);

    @Mapping(target = "idAreaInteres", source = "areaId")
    @Mapping(target = "areaInteres", source = "areaNombre")
    public abstract AreaInteresEntity areaInteresDtoToAreaInteresEntity(AreaInteresDto areaInteresDto);
}
