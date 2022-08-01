import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  CustomTableConfiguration,
  CustomTableHeader,
  CustomTableItem,
} from 'src/app/components/custom-table/custom-table.configuration.dto';
import { SedeRequest } from 'src/app/managers/request-dto/sede.request';
import { SedeManagerService } from 'src/app/managers/sede-manager/sede-manager.service';

@Component({
  selector: 'app-list-sede-view',
  templateUrl: './list-sede-view.component.html',
  styleUrls: ['./list-sede-view.component.scss'],
})
export class ListSedeViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;

  constructor(
    public sedeManagerService: SedeManagerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createTableConfig();
  }

  createTableConfig() {
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Nombre',
      },
      {
        label: 'Código',
      },
      {
        label: 'Ubicación',
      },
    ];
    config.dataConfig = [
      {
        key: 'nombre',
      },
      {
        key: 'codigo',
      },
      {
        key: 'direccion',
      },
    ];
    this.configTable = config;
  }

  editSede(sedeEdit: SedeRequest) {
    this.router.navigate(['/config/sede/edit', sedeEdit.sedeId]);
  }
}
