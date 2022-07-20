import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WindowComponent } from './window.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { CustomConfirmDialogModule } from '../custom-confirm-dialog/custom-confirm-dialog.module';

@NgModule({
  declarations: [WindowComponent],
  imports: [CommonModule, CardModule, ButtonModule, CustomConfirmDialogModule],
  exports: [WindowComponent],
})
export class WindowModule {}
