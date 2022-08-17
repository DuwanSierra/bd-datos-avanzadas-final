import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomTableConfiguration } from 'src/app/components/custom-table/custom-table.configuration.dto';
import { GrupoInvestigacionManagerService } from '../../../managers/grupo-investigacion-manager/grupo-investigacion-manager.service';
import { GrupoInvestigacionRequest } from '../../../managers/request-dto/grupo-investigacion.request';

@Component({
  selector: 'app-list-investigation-group-view',
  templateUrl: './list-investigation-group-view.component.html',
  styleUrls: ['./list-investigation-group-view.component.scss']
})
export class ListInvestigationGroupViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;
  constructor(public investigationGroupManager: GrupoInvestigacionManagerService, public router: Router) { }

  ngOnInit(): void {
    this.createConfigTable();
  }

  createConfigTable(){
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Codigo del grupo',
      },
      {
        label: 'Nombre del grupo',
      },
      {
        label: 'Docente encargado del grupo',
      },
    ];
    config.dataConfig = [
      {
        key: 'codigoGrupoInvestigacion',
      },
      {
        key: 'nombreGrupoInvestigacion',
      },
      {
        key: 'profesor.nombreProfesor',
      },
    ];
    this.configTable = config;
  }

  editGrupo(GroupEdit: GrupoInvestigacionRequest) {
    this.router.navigate(['/investigation-group/edit',GroupEdit.nombreGrupoInvestigacion,GroupEdit.codigoGrupoInvestigacion]);
  }
}
