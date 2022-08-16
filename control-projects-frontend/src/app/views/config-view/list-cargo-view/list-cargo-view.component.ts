import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomTableConfiguration } from 'src/app/components/custom-table/custom-table.configuration.dto';
import { CargoManagerService } from 'src/app/managers/cargo-manager/cargo-manager.service';
import { CargoRequest } from 'src/app/managers/request-dto/cargo.request';

@Component({
  selector: 'app-list-cargo-view',
  templateUrl: './list-cargo-view.component.html',
  styleUrls: ['./list-cargo-view.component.scss'],
})
export class ListCargoViewComponent implements OnInit {
  public configTable?: CustomTableConfiguration;

  constructor(
    public cargoManagerService: CargoManagerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.createConfigTable();
  }

  createConfigTable() {
    let config = new CustomTableConfiguration();
    config.headers = [
      {
        label: 'Cargo',
      },
    ];
    config.dataConfig = [
      {
        key: 'cargo',
      },
    ];
    this.configTable = config;
  }

  editCargo(cargoEdit: CargoRequest) {
    this.router.navigate(['/config/cargo/edit', cargoEdit.cargoId]);
  }
}
