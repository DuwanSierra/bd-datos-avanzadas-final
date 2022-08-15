import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { RolRequest } from 'src/app/managers/request-dto/rol.request';
import { RolManagerService } from 'src/app/managers/rol-manager/rol-manager.service';

@Injectable({
  providedIn: 'root'
})
export class CreateRolViewService {

  public rol = new BehaviorSubject<RolRequest>(
    new RolRequest()
  );

  constructor(
    private rolManagerService: RolManagerService,
    private router: Router
  ) {}

  public createRol(rolName: string) {
    let rol = new RolRequest();
    rol.rol = rolName;
    this.rolManagerService.createRol(rol).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['config/rol/list']);
    });
  }

  public editRol(rolName: string) {
    let rol = new RolRequest();
    rol.rol = rolName;
    rol.rolId = this.rol.value.rolId;
    this.rolManagerService.editRol(rol).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['config/rol/list']);
    });
  }

  public findRol(rolId: number) {
    this.rolManagerService
      .findRol(rolId)
      .subscribe((res: RolRequest) => {
        this.rol.next(res);
      });
  }

  public resetAll() {
    this.rol.next(new RolRequest());
  }
}
