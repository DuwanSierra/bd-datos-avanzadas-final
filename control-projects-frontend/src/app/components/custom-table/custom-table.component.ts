import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { LazyLoadEvent } from 'primeng/api';
import { Table } from 'primeng/table';
import { DeleteDto } from 'src/app/@core/dto/delete.dto';
import { CustomConfirmDialogDto } from '../custom-confirm-dialog/custom-confim-dialog.dto';
import { CustomConfimDialogService } from '../custom-confirm-dialog/custom-confim-dialog.service';
import { CustomTableConfiguration } from './custom-table.configuration.dto';
import { CustomTablePaginateDto } from './custom-table.paginate.dto';
import { CustomTablePaginatorDto } from './custom-table.paginator.dto';

@Component({
  selector: 'custom-table',
  templateUrl: './custom-table.component.html',
  styleUrls: ['./custom-table.component.scss'],
})
export class CustomTableComponent implements OnInit {
  @ViewChild('customDataTable')
  dataTableComponent?: Table;

  @Input() service: any;
  @Input() methodGetData: string = '';
  @Input() methodDelete: string = '';
  @Input() rows = 5;
  @Input() configuration?: CustomTableConfiguration;

  @Output() editEvent = new EventEmitter();

  loading = false;
  totalRecords = 0;

  public data: any[] = [];
  public dataSelected: any[] = [];

  constructor(private customConfimDialog: CustomConfimDialogService) {}

  ngOnInit(): void {}

  loadData(event: LazyLoadEvent) {
    if (this.service && this.methodGetData) {
      this.loading = true;
      let paginate = new CustomTablePaginateDto();
      paginate.size = event.rows;
      paginate.page = Math.ceil(
        ((event.first || 1) - 1) / (paginate.size || 5)
      );
      this.service[this.methodGetData](paginate)?.subscribe(
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

  tableEditEvent(event: any) {
    if (event) {
      this.editEvent.emit(event);
    }
  }

  deleteEvent(event: any) {
    let data = new CustomConfirmDialogDto();
    data.acceptEvent = () => {
      this.deleteAction(event);
    };
    data.message = '¿Está seguro de eliminar este registro?';
    data.title = 'Atención';
    data.icon = 'pi pi-exclamation-triangle';
    this.customConfimDialog.confirmDialog(data);
  }

  printDataByKey(key: string, item: any) {
    let text = item[key];
    if (key.includes('.')) {
      let keysExplore = key.split('.');
      let initialItem = Object.assign({},item);
      keysExplore.forEach(keySelect=>{
        if(initialItem[keySelect]){
          initialItem = initialItem[keySelect];
        }
      });
      text = initialItem;
    }
    return text;
  }

  private deleteAction(data: any) {
    if (this.service && this.methodDelete) {
      this.service[this.methodDelete](data).subscribe((res: DeleteDto) => {
        this.dataTableComponent?.reset();
        //TODO: Incluir dialog de exito.
      });
    }
  }
}
