import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomMultipleInputTextComponent } from './custom-multiple-input-text.component';
import { InputTextFormModule } from '../input-text-form/input-text-form.module';

@NgModule({
  declarations: [CustomMultipleInputTextComponent],
  imports: [CommonModule, InputTextFormModule],
  exports: [CustomMultipleInputTextComponent],
})
export class CustomMultipleInputTextModule {}
