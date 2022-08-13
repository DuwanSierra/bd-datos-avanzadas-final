package com.udistrital.controlprojectsbackend.mappers;

import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.repository.entity.CargoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CargoMapper {

    @Mapping(target = "cargoId", source = "idCargo")
    @Mapping(target = "cargo", source = "cargo")
    public abstract CargoDto cargoEntityToCargoDto(CargoEntity cargoEntity);
    @Mapping(source = "cargoId", target = "idCargo")
    @Mapping(source = "cargo", target = "cargo")
    public abstract CargoEntity cargoDtoToCargoEntity(CargoDto cargoDto);
}
