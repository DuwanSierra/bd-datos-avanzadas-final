import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { GrupoInvestigacionManagerService } from 'src/app/managers/grupo-investigacion-manager/grupo-investigacion-manager.service';
import { ProyectoInvestigacionRequest } from 'src/app/managers/request-dto/proyecto-investigacion.request';
import { GenericView } from 'src/app/utils/generic-view';
import { CreateInvestigationProjectViewService } from './create-investigation-project-view.service';
@Component({
  selector: 'app-create-investigation-project-view',
  templateUrl: './create-investigation-project-view.component.html',
  styleUrls: ['./create-investigation-project-view.component.scss'],
})
export class CreateInvestigationProjectViewComponent
  extends GenericView
  implements OnInit
{
  proyectoInvestigacion = new ProyectoInvestigacionRequest();
  title = 'Crear Grupo de Investigación';

  constructor(
    public override activatedRoute: ActivatedRoute,
    public grupoInvestigacionManager: GrupoInvestigacionManagerService,
    public proyectoCreateService: CreateInvestigationProjectViewService
  ) {
    super(activatedRoute);
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.proyectoCreateService.editProject(this.proyectoInvestigacion)
        : this.proyectoCreateService.createProject(this.proyectoInvestigacion);
    }
  }

  ngOnInit(): void {
    this.getCurrentData();
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar grupo de investigación';
  }

  override afterLoadParams(data: any): void {
    if (data?.nombre && data?.codigo && data?.codigoProyecto) {
      this.proyectoCreateService.findProject(data?.nombre, data?.codigo, data?.codigoProyecto);
    } else {
      this.proyectoCreateService.resetAll();
    }
  }

  getCurrentData() {
    this.proyectoCreateService.proyectoInvestigacionDto.subscribe((res) => {
      this.proyectoInvestigacion = res;
    });
  }
}
