import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProfesorManagerService } from 'src/app/managers/profesor-manager/profesor-manager.service';
import { ProyectoInvestigacionManagerService } from 'src/app/managers/proyecto-vestigacion-manager/proyecto-investigacion-manager.service';
import { ParticipaRequest } from 'src/app/managers/request-dto/participa.request';
import { RolManagerService } from 'src/app/managers/rol-manager/rol-manager.service';
import { GenericView } from 'src/app/utils/generic-view';
import { AddParticipaProjectViewService } from './add-participa-project-view.service';

@Component({
  selector: 'app-add-participa-project-view',
  templateUrl: './add-participa-project-view.component.html',
  styleUrls: ['./add-participa-project-view.component.scss'],
})
export class AddParticipaProjectViewComponent
  extends GenericView
  implements OnInit
{
  participaDto = new ParticipaRequest();
  title = 'Crear participación';

  constructor(
    public override activatedRoute: ActivatedRoute,
    public rolManager: RolManagerService,
    public profesorManager: ProfesorManagerService,
    public proyectoInvestigacionManager: ProyectoInvestigacionManagerService,
    public participaProyecto: AddParticipaProjectViewService
  ) {
    super(activatedRoute);
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.participaProyecto.editParticipa(this.participaDto)
        : this.participaProyecto.createParticipa(this.participaDto);
    }
  }

  ngOnInit(): void {
    this.getCurrentData();
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar participación';
  }

  override afterLoadParams(data: any): void {
    if (data?.nombreGrupo && data?.codigoGrupo && data?.codigoProyecto && data?.cedula) {
      this.participaProyecto.findParticipa(
        data?.nombreGrupo,
        data?.codigoGrupo,
        data?.codigoProyecto,
        data?.cedula
      );
    } else {
      this.participaProyecto.resetAll();
    }
  }

  getCurrentData() {
    this.participaProyecto.participaRequestDto.subscribe((res) => {
      this.participaDto = res;
    });
  }
}
