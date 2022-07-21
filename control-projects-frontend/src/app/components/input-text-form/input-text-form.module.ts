import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputTextFormComponent } from './input-text-form.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [InputTextFormComponent],
  imports: [CommonModule, InputTextModule, FormsModule, ReactiveFormsModule],
  exports: [InputTextFormComponent],
})
export class InputTextFormModule {}
