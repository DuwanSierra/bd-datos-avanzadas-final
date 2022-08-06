import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputTextFormComponent } from './input-text-form.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TooltipModule } from 'primeng/tooltip';

@NgModule({
  declarations: [InputTextFormComponent],
  imports: [
    CommonModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    TooltipModule,
  ],
  exports: [InputTextFormComponent],
})
export class InputTextFormModule {}
