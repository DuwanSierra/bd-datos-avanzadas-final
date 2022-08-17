import { Component, OnInit } from '@angular/core';
import { GenericView } from 'src/app/utils/generic-view';
import { ActivatedRoute } from '@angular/router';
import { ProfesorManagerService } from 'src/app/managers/profesor-manager/profesor-manager.service';
import { FacultyManagerService } from 'src/app/managers/facultad-manager/faculty-manager.service';
import { GrupoInvestigacionRequest } from 'src/app/managers/request-dto/grupo-investigacion.request';
import { AreaInteresManagerService } from 'src/app/managers/area-interes-manager/area-interes-manager.service';
import { CreateInvestigationGroupService } from './create-investigation-group.service';

@Component({
  selector: 'app-create-investigation-group-view',
  templateUrl: './create-investigation-group-view.component.html',
  styleUrls: ['./create-investigation-group-view.component.scss'],
})
export class CreateInvestigationGroupViewComponent
  extends GenericView
  implements OnInit
{
  grupoInvestigacion = new GrupoInvestigacionRequest();
  title = 'Crear Grupo de Investigación';

  constructor(
    public override activatedRoute: ActivatedRoute,
    public profesorManager: ProfesorManagerService,
    public areaInteresManager: AreaInteresManagerService,
    public facultadManager: FacultyManagerService,
    public grupoInvestigacionService: CreateInvestigationGroupService
  ) {
    super(activatedRoute);
  }

  saveEvent(isValid: boolean) {
    if (isValid) {
      this.isEdit
        ? this.grupoInvestigacionService.editGrupo(
            this.grupoInvestigacion
          )
        : this.grupoInvestigacionService.createGrupo(
          this.grupoInvestigacion
        )
    }
  }

  ngOnInit(): void {
    this.getCurrentData();
  }

  override afterCheckIsEditMode(): void {
    this.title = 'Editar grupo de investigación';
  }

  override afterLoadParams(data: any): void {
    if (data?.nombre && data?.codigo) {
      this.grupoInvestigacionService.findGrupo(data?.nombre, data?.codigo);
    } else {
      this.grupoInvestigacionService.resetAll();
    }
  }

  getCurrentData() {
    this.grupoInvestigacionService.grupoInvestigacionDto.subscribe((res) => {
      this.grupoInvestigacion = res;
    });
  }
}
