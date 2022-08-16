import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomTableConfiguration } from 'src/app/components/custom-table/custom-table.configuration.dto';
import { ProfesorManagerService } from 'src/app/managers/profesor-manager/profesor-manager.service';
import { ProfessorRequest } from 'src/app/managers/request-dto/professor.request';
@Component({
  selector: 'app-list-professor-view',
  templateUrl: './list-professor-view.component.html',
  styleUrls: ['./list-professor-view.component.scss']
})
export class ListprofessorViewComponent implements OnInit {
 
  public configTable?: CustomTableConfiguration;

  constructor(public professormanager: ProfesorManagerService, public router: Router) { }

  ngOnInit(): void {
    this.createConfigTable();
  }
  createConfigTable(){
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Nombre',
      },
      {
        label: 'Numero de Cedula',
      },
      {
        label: 'Inicio de investigacion',
      },
      {
        label: 'Facultad',
      },
      {
        label: 'Cargo',
      },
      {
        label: 'Titulos del profesor.',
      },
    ];
    config.dataConfig = [
      {
        key: 'nombreProfesor',
      },
      {
        key: 'cedulaProfesor',
      },
      {
        key: 'inicioInvestigacion',
      },
      {
        key: 'aniosInvestigacion',
      },
      {
        key: 'facultad.facultadNombre',
      },
      {
        key: 'cargo.cargo',
      },
      {
        key: 'cedulaProfesor',
      },
    ];
    this.configTable = config;
  }
  editProfesor(profesorEdit: ProfessorRequest) {
    this.router.navigate(['/professor/edit', profesorEdit.cedulaProfesor]);
  }

}
