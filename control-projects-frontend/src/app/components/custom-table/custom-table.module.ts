import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomTableComponent } from './custom-table.component';
import { TableModule } from 'primeng/table';

@NgModule({
  declarations: [CustomTableComponent],
  imports: [CommonModule, TableModule],
  exports: [CustomTableComponent],
})
export class CustomTableModule {}
