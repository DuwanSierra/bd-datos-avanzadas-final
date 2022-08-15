import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CargoRequest } from 'src/app/managers/request-dto/cargo.request';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateCargoViewService } from './create-cargo-view.service';

@Component({
  selector: 'app-create-cargo-view',
  templateUrl: './create-cargo-view.component.html',
  styleUrls: ['./create-cargo-view.component.scss']
})
export class CreateCargoViewComponent extends GenericView implements OnInit {
  title: string = 'Crear nueva sede';
  public nombreCargo = '';
  constructor(
    public override activatedRoute: ActivatedRoute,
    public createCargoService: CreateCargoViewService
  ) {
    super(activatedRoute);
  }

  ngOnInit(): void {
    this.getCurrentSede();
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.createCargoService.editCargo(this.nombreCargo)
        : this.createCargoService.createCargo(this.nombreCargo);
    }
  }

  getCurrentSede() {
    this.createCargoService.cargoDto.subscribe((cargo: CargoRequest) => {
      this.nombreCargo = cargo.cargo || '';
    });
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar cargo';
  }

  override afterLoadParams(data: any): void {
    if (data?.id) {
      this.createCargoService.findCargo(data?.id);
    } else {
      this.createCargoService.resetAll();
    }
  }
}

