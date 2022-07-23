import { Component, Input, OnInit } from '@angular/core';
import { LazyLoadEvent } from 'primeng/api';
import { CustomTableConfiguration } from './custom-table.configuration.dto';
import { CustomTablePaginateDto } from './custom-table.paginate.dto';
import { CustomTablePaginatorDto } from './custom-table.paginator.dto';

@Component({
  selector: 'custom-table',
  templateUrl: './custom-table.component.html',
  styleUrls: ['./custom-table.component.scss'],
})
export class CustomTableComponent implements OnInit {
  @Input() service: any;
  @Input() method: string = '';
  @Input() rows = 10;
  @Input() configuration?: CustomTableConfiguration;

  loading = false;
  totalRecords = 0;

  public data: any[] = [];
  public dataSelected: any[] = [];

  constructor() {}

  ngOnInit(): void {}

  loadData(event: LazyLoadEvent) {
    if (this.service && this.method) {
      this.loading = true;
      let paginate = new CustomTablePaginateDto();
      paginate.page = event.first;
      paginate.size = event.rows;
      this.service[this.method](paginate)?.subscribe(
        (res: CustomTablePaginatorDto) => {
          this.data = res.content;
          this.totalRecords = res.totalElements;
          this.loading = false;
        }
      );
    }
  }

  onSelectionChange(value = []) {
    this.dataSelected = value;
  }
}
