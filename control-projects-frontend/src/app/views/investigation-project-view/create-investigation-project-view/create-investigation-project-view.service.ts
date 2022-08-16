import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { ProyectoInvestigacionManagerService } from 'src/app/managers/proyecto-vestigacion-manager/proyecto-investigacion-manager.service';
import { ProyectoInvestigacionRequest } from 'src/app/managers/request-dto/proyecto-investigacion.request';

@Injectable({
  providedIn: 'root'
})
export class CreateInvestigationProjectViewService {

  public proyectoInvestigacionDto = new BehaviorSubject<ProyectoInvestigacionRequest>(
    new ProyectoInvestigacionRequest()
  );

  constructor(
    private proyectoManager: ProyectoInvestigacionManagerService,
    private router: Router
  ) {}

  public createProject(grupo: ProyectoInvestigacionRequest) {
    this.proyectoManager.createProject(grupo).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['investigation-project/list']);
    });
  }

  public editProject(grupo: ProyectoInvestigacionRequest) {
    this.proyectoManager
      .editProject(
        grupo,
        this.proyectoInvestigacionDto.value.grupoInvestigacion?.nombreGrupoInvestigacion || '',
        this.proyectoInvestigacionDto.value.grupoInvestigacion?.codigoGrupoInvestigacion || 0,
        this.proyectoInvestigacionDto.value.codigo || 0,
      )
      .subscribe((res) => {
        this.resetAll();
        this.router.navigate(['investigation-project/list']);
      });
  }

  public findProject(grupoNombre: string, grupoCodigo: number, codigoProyecto: number) {
    this.proyectoManager
      .findProject(grupoNombre,grupoCodigo, codigoProyecto)
      .subscribe((res: ProyectoInvestigacionRequest) => {
        this.proyectoInvestigacionDto.next(res);
      });
  }

  public resetAll() {
    this.proyectoInvestigacionDto.next(new ProyectoInvestigacionRequest());
  }
}
