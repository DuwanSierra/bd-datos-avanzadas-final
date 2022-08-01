import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { SedeRequest } from 'src/app/managers/request-dto/sede.request';
import { SedeManagerService } from 'src/app/managers/sede-manager/sede-manager.service';

@Injectable({
  providedIn: 'root'
})
export class CreateSedeViewService {
  public sedeDto = new BehaviorSubject<SedeRequest>(
    new SedeRequest()
  );

  constructor(
    private sedeManagerService: SedeManagerService,
    private router: Router
  ) {}

  public createSede(nombre: string, codigo: string) {
    let sedeCreate = new SedeRequest();
    sedeCreate.nombre = nombre;
    sedeCreate.codigo = codigo;
    this.sedeManagerService.createSede(sedeCreate).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['config/sede/list']);
    });
  }

  public editSede(nombre: string, codigo: string) {
    let sedeCreate = new SedeRequest();
    sedeCreate.nombre = nombre;
    sedeCreate.codigo = codigo;
    sedeCreate.sedeId = this.sedeDto.value.sedeId;
    this.sedeManagerService.editSede(sedeCreate).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['config/sede/list']);
    });
  }

  public findSede(sedeId: number) {
    this.sedeManagerService
      .findSedeById(sedeId)
      .subscribe((res: SedeRequest) => {
        this.sedeDto.next(res);
      });
  }

  public resetAll() {
    this.sedeDto.next(new SedeRequest());
  }
}
