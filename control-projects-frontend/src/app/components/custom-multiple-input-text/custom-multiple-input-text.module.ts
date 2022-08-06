import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomMultipleInputTextComponent } from './custom-multiple-input-text.component';
import { InputTextFormModule } from '../input-text-form/input-text-form.module';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';

@NgModule({
  declarations: [CustomMultipleInputTextComponent],
  imports: [CommonModule, InputTextFormModule, ButtonModule, TooltipModule],
  exports: [CustomMultipleInputTextComponent],
})
export class CustomMultipleInputTextModule {}
