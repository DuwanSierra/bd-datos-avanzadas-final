import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomTableComponent } from './custom-table.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';

@NgModule({
  declarations: [CustomTableComponent],
  imports: [CommonModule, TableModule, ButtonModule],
  exports: [CustomTableComponent],
})
export class CustomTableModule {}
