import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomSpinnerComponent } from './custom-spinner.component';
import { ProgressSpinnerModule } from 'primeng/progressspinner';

@NgModule({
  declarations: [CustomSpinnerComponent],
  imports: [CommonModule, ProgressSpinnerModule],
  exports: [CustomSpinnerComponent],
})
export class CustomSpinnerModule {}
