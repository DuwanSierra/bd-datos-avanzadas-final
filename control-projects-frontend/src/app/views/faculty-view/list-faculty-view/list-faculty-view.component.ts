import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomTableConfiguration } from 'src/app/components/custom-table/custom-table.configuration.dto';
import { FacultyManagerService } from 'src/app/managers/facultad-manager/faculty-manager.service';
import { FacultyRequest } from 'src/app/managers/request-dto/faculty.request';

@Component({
  selector: 'app-list-faculty-view',
  templateUrl: './list-faculty-view.component.html',
  styleUrls: ['./list-faculty-view.component.scss']
})
export class ListFacultyViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;

  constructor(public facultyManager: FacultyManagerService, public router: Router) { }

  ngOnInit(): void {
    this.createConfigTable();
  }

  createConfigTable(){
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Facultad',
      },
      {
        label: 'Sede',
      },
    ];
    config.dataConfig = [
      {
        key: 'facultadNombre',
      },
      {
        key: 'sede.nombre',
      },
    ];
    this.configTable = config;
  }

  editFacultad(facultyedit: FacultyRequest) {
    this.router.navigate(['/faculty/edit', facultyedit.facultadNombre]);
  }

}
