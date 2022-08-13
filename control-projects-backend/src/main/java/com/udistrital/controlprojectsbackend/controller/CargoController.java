package com.udistrital.controlprojectsbackend.controller;

import com.udistrital.controlprojectsbackend.command.areainteres.CreateAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.areainteres.DeleteAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.areainteres.EditAreaInteresCommand;
import com.udistrital.controlprojectsbackend.command.cargo.CreateCargoCommand;
import com.udistrital.controlprojectsbackend.command.cargo.DeleteCargoCommand;
import com.udistrital.controlprojectsbackend.command.cargo.EditCargoCommand;
import com.udistrital.controlprojectsbackend.controller.dto.AreaInteresDto;
import com.udistrital.controlprojectsbackend.controller.dto.CargoDto;
import com.udistrital.controlprojectsbackend.controller.dto.DeleteDto;
import com.udistrital.controlprojectsbackend.query.area.FindAreaInteresByIdQuery;
import com.udistrital.controlprojectsbackend.query.area.FindAreaInteresQuery;
import com.udistrital.controlprojectsbackend.query.cargo.FindCargoByIdQuery;
import com.udistrital.controlprojectsbackend.query.cargo.FindCargoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/cargo")
@CrossOrigin(origins = "http://localhost:4200")
public class CargoController {
    private final CreateCargoCommand _createCargoCommand;
    private final FindCargoQuery _findCargoQuery;
    private final DeleteCargoCommand _deleteCargoCommand;
    private final FindCargoByIdQuery _findCargoByIdQuery;
    private final EditCargoCommand _editCargoCommand;

    @Autowired
    public CargoController(CreateCargoCommand createCargoCommand,
                           FindCargoQuery findCargoQuery,
                           DeleteCargoCommand deleteCargoCommand,
                           FindCargoByIdQuery findCargoByIdQuery,
                           EditCargoCommand editCargoCommand
    ) {
        _createCargoCommand = createCargoCommand;
        _findCargoQuery = findCargoQuery;
        _deleteCargoCommand = deleteCargoCommand;
        _findCargoByIdQuery = findCargoByIdQuery;
        _editCargoCommand = editCargoCommand;
    }

    @PostMapping("/create")
    private Mono<CargoDto> createCargo(@RequestBody CargoDto cargoDto) {
        return _createCargoCommand.CreateCargo(cargoDto);
    }

    @PutMapping("/edit/{id}")
    private Mono<CargoDto> editCargo(@RequestBody CargoDto cargoDto, @PathVariable long id) {
        return _editCargoCommand.EditCargo(cargoDto, id);
    }

    @GetMapping("/all")
    private Mono<Page<CargoDto>> getAllCargo(@RequestParam long page, @RequestParam long size) {
        return _findCargoQuery.FindAllCargos(page, size);
    }

    @DeleteMapping("/delete/{id}")
    private Mono<DeleteDto> deleteCargo(@PathVariable long id) {
        return _deleteCargoCommand.deleteCargo(id);
    }

    @GetMapping("/find/{id}")
    private Mono<CargoDto> findCargo(@PathVariable long id) {
        return _findCargoByIdQuery.FindCargoById(id);
    }
}
