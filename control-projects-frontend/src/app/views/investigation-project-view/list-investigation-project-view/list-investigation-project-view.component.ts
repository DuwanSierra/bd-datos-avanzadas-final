import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomTableConfiguration } from 'src/app/components/custom-table/custom-table.configuration.dto';
import { ProyectoInvestigacionManagerService } from 'src/app/managers/proyecto-vestigacion-manager/proyecto-investigacion-manager.service';
import { ProyectoInvestigacionRequest } from 'src/app/managers/request-dto/proyecto-investigacion.request';
@Component({
  selector: 'app-list-investigation-project-view',
  templateUrl: './list-investigation-project-view.component.html',
  styleUrls: ['./list-investigation-project-view.component.scss']
})
export class ListInvestigationProjectViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;
  
  constructor(public investigationProyectManager: ProyectoInvestigacionManagerService, public router: Router) { }

  ngOnInit(): void {
    this.createConfigTable();
  }
  createConfigTable() {
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Nombre',
      },
      {
        label: 'Presupuesto',
      },
      {
        label: 'Fecha inicio',
      },
      {
        label: 'Fecha Finalización',
      },
    ];
    config.dataConfig = [
      {
        key: 'nombre',
      },
      {
        key: 'presupuesto',
      },
      {
        key: 'fechaInicio',
        type: 'Date'
      },
      {
        key: 'fechaTerminacion',
        type: 'Date'
      },
    ];
    this.configTable = config;
  }

  editProject(projectEdit: ProyectoInvestigacionRequest) {
    this.router.navigate(['/investigation-project/edit', projectEdit.codigo]);
  }


}
