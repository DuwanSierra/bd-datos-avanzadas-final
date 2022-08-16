import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { GrupoInvestigacionManagerService } from 'src/app/managers/grupo-investigacion-manager/grupo-investigacion-manager.service';
import { GrupoInvestigacionRequest } from 'src/app/managers/request-dto/grupo-investigacion.request';

@Injectable({
  providedIn: 'root',
})
export class CreateInvestigationGroupService {
  public grupoInvestigacionDto = new BehaviorSubject<GrupoInvestigacionRequest>(
    new GrupoInvestigacionRequest()
  );

  constructor(
    private grupoManager: GrupoInvestigacionManagerService,
    private router: Router
  ) {}

  public createGrupo(grupo: GrupoInvestigacionRequest) {
    this.grupoManager.createGrupo(grupo).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['investigation-group/list']);
    });
  }

  public editGrupo(grupo: GrupoInvestigacionRequest) {
    this.grupoManager
      .editGrupo(
        grupo,
        this.grupoInvestigacionDto.value.nombreGrupoInvestigacion || '',
        this.grupoInvestigacionDto.value.codigoGrupoInvestigacion || 0
      )
      .subscribe((res) => {
        this.resetAll();
        this.router.navigate(['investigation-group/list']);
      });
  }

  public findGrupo(grupoNombre: string, grupoCodigo: number) {
    this.grupoManager
      .findGrupo(grupoNombre,grupoCodigo)
      .subscribe((res: GrupoInvestigacionRequest) => {
        this.grupoInvestigacionDto.next(res);
      });
  }

  public resetAll() {
    this.grupoInvestigacionDto.next(new GrupoInvestigacionRequest());
  }
}
