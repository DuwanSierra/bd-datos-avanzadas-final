import { Injectable } from '@angular/core';
import { ConfirmationService, ConfirmEventType } from 'primeng/api';
import { CustomConfirmDialogDto } from './custom-confim-dialog.dto';

@Injectable({
  providedIn: 'root',
})
export class CustomConfimDialogService {
  constructor(private confirmationService: ConfirmationService) {}

  confirmDialog(options: CustomConfirmDialogDto) {
    this.confirmationService.confirm({
      message: options.message || 'Title',
      header: options.title || 'Title',
      icon: options.icon || 'pi pi-exclamation-triangle',
      acceptLabel: options.labelAcceptButton || 'Aceptar',
      rejectLabel: options.labelCancelButton || 'Cancelar',
      accept: () => {
        if (options.acceptEvent) {
          options.acceptEvent();
        }
      },
      reject: (type: ConfirmEventType) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            if (options.rejectEvent) {
              options.rejectEvent();
            }
            break;
          case ConfirmEventType.CANCEL:
            if (options.cancelevent) {
              options.cancelevent();
            }
            break;
        }
      },
    });
  }
}
