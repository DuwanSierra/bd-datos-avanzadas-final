import { Component, OnInit } from '@angular/core';
import {
  CustomTableConfiguration,
  CustomTableHeader,
  CustomTableItem,
} from 'src/app/components/custom-table/custom-table.configuration.dto';
import { AreaInteresManagerService } from 'src/app/managers/area-interes-manager/area-interes-manager.service';

@Component({
  selector: 'app-list-catalog-view',
  templateUrl: './list-catalog-view.component.html',
  styleUrls: ['./list-catalog-view.component.scss'],
})
export class ListCatalogViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;

  constructor(public areaInteresManager: AreaInteresManagerService) {}

  ngOnInit(): void {
    this.createTableConfig();
  }

  createTableConfig() {
    let config = new CustomTableConfiguration();
    let header = new CustomTableHeader();
    let item = new CustomTableItem();
    header.label = 'Nombre';
    item.key = 'areaNombre';
    config.headers = [header];
    config.dataConfig = [item];
    this.configTable = config;
  }
}
