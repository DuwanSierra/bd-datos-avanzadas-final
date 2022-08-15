import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { CargoManagerService } from 'src/app/managers/cargo-manager/cargo-manager.service';
import { CargoRequest } from 'src/app/managers/request-dto/cargo.request';

@Injectable({
  providedIn: 'root'
})
export class CreateCargoViewService {

  public cargoDto = new BehaviorSubject<CargoRequest>(
    new CargoRequest()
  );

  constructor(
    private cargoManager: CargoManagerService,
    private router: Router
  ) {}

  public createCargo(nombre: string) {
    let cargo = new CargoRequest();
    cargo.cargo = nombre;
    this.cargoManager.createCargo(cargo).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['config/cargo/list']);
    });
  }

  public editCargo(nombre: string) {
    let cargoCreate = new CargoRequest();
    cargoCreate.cargo = nombre;
    cargoCreate.cargoId = this.cargoDto.value.cargoId;
    this.cargoManager.editCargo(cargoCreate).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['config/cargo/list']);
    });
  }

  public findCargo(cargoId: number) {
    this.cargoManager
      .findCargo(cargoId)
      .subscribe((res: CargoRequest) => {
        this.cargoDto.next(res);
      });
  }

  public resetAll() {
    this.cargoDto.next(new CargoRequest());
  }
}
