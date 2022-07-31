import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { AreaInteresManagerService } from 'src/app/managers/area-interes-manager/area-interes-manager.service';
import { AreaInteresRequest } from 'src/app/managers/request-dto/area-interes.request';

@Injectable({
  providedIn: 'root',
})
export class CreateCatalogViewService {

  public areaInteresDto = new BehaviorSubject<AreaInteresRequest>(new AreaInteresRequest());

  constructor(
    private areaInteresManager: AreaInteresManagerService,
    private router: Router
  ) {}

  public createAreaInteres(nombreAreaInteres: string) {
    let areaCreate = new AreaInteresRequest();
    areaCreate.areaNombre = nombreAreaInteres;
    this.areaInteresManager.createAreaInteres(areaCreate).subscribe((res) => {
      this.areaInteresDto.next(new AreaInteresRequest());
      this.router.navigate(['config/list']);
    });
  }

  public editAreaInteres(nombreAreaInteres: string) {
    let areaCreate = new AreaInteresRequest();
    areaCreate.areaNombre = nombreAreaInteres;
    areaCreate.areaId = this.areaInteresDto.value.areaId;
    this.areaInteresManager.editAreaInteres(areaCreate).subscribe((res) => {
      this.areaInteresDto.next(new AreaInteresRequest());
      this.router.navigate(['config/list']);
    });
  }

  public findAreaInteres(areaInteresId: number){
    this.areaInteresManager.findAreaInteres(areaInteresId).subscribe((res: AreaInteresRequest)=>{
      this.areaInteresDto.next(res);
    });
  }
}
