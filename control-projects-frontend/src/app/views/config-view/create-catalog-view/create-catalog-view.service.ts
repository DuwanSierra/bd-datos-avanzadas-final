import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AreaInteresManagerService } from 'src/app/managers/area-interes-manager/area-interes-manager.service';
import { AreaInteresRequest } from 'src/app/managers/request-dto/area-interes.request';

@Injectable({
  providedIn: 'root',
})
export class CreateCatalogViewService {
  constructor(
    private areaInteresManager: AreaInteresManagerService,
    private router: Router
  ) {}

  public createAreaInteres(nombreAreaInteres: string) {
    let areaCreate = new AreaInteresRequest();
    areaCreate.areaNombre = nombreAreaInteres;
    this.areaInteresManager.createAreaInteres(areaCreate).subscribe((res) => {
      this.router.navigate(['config/list']);
    });
  }
}
