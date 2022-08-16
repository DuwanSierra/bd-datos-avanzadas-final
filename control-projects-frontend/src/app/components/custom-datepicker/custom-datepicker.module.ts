import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomDatepickerComponent } from './custom-datepicker.component';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TooltipModule } from 'primeng/tooltip';

@NgModule({
  declarations: [CustomDatepickerComponent],
  imports: [
    CommonModule,
    CalendarModule,
    FormsModule,
    ReactiveFormsModule,
    TooltipModule,
  ],
  exports: [CustomDatepickerComponent],
})
export class CustomDatepickerModule {}
