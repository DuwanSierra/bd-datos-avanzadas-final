import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomConfirmDialogComponent } from './custom-confirm-dialog.component';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';

@NgModule({
  declarations: [CustomConfirmDialogComponent],
  imports: [CommonModule, ConfirmDialogModule],
  providers: [ConfirmationService],
  exports: [CustomConfirmDialogComponent],
})
export class CustomConfirmDialogModule {}
