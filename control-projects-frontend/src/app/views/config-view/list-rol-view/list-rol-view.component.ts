import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomTableConfiguration } from 'src/app/components/custom-table/custom-table.configuration.dto';
import { RolRequest } from 'src/app/managers/request-dto/rol.request';
import { RolManagerService } from 'src/app/managers/rol-manager/rol-manager.service';

@Component({
  selector: 'app-list-rol-view',
  templateUrl: './list-rol-view.component.html',
  styleUrls: ['./list-rol-view.component.scss']
})
export class ListRolViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;

  constructor(public rolManagerService: RolManagerService, private router: Router) { }

  ngOnInit(): void {
    this.createConfigTable();
  }

  createConfigTable(){
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Rol',
      },
    ];
    config.dataConfig = [
      {
        key: 'rol',
      },
    ];
    this.configTable = config;
  }

  editRol(rolEdit: RolRequest) {
    this.router.navigate(['/config/rol/edit', rolEdit.rolId]);
  }

}
