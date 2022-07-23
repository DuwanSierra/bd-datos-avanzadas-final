import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { CustomConfirmDialogDto } from '../custom-confirm-dialog/custom-confim-dialog.dto';
import { CustomConfimDialogService } from '../custom-confirm-dialog/custom-confim-dialog.service';
import { WindowConstants } from './window.constants';

@Component({
  selector: 'window-template',
  templateUrl: './window.component.html',
  styleUrls: ['./window.component.scss'],
})
export class WindowComponent implements OnInit {
  // Inputs
  @Input() title?: string;
  @Input() showActions = false;
  @Input() customFormGroup: FormGroup = new FormGroup({});
  @Input() validateForm = false;

  //Outputs
  @Output() closeEvent = new EventEmitter<boolean>();
  @Output() maximiseEvent = new EventEmitter<boolean>();
  @Output() minimiseEvent = new EventEmitter<boolean>();
  @Output() actionPrimaryEvent = new EventEmitter<boolean>();

  //variables
  public isFullScreen = false;
  public autoNavigateInit = true;

  public CONSTANTS = WindowConstants;

  constructor(
    private customConfimDialog: CustomConfimDialogService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  buttonAction(action: string) {
    switch (action) {
      case this.CONSTANTS.ACTION_CLOSE:
        if (this.autoNavigateInit) {
          let data = new CustomConfirmDialogDto();
          data.acceptEvent = () => {
            this.navigateInit();
          };
          data.message = '¿Está seguro de cerrar esta vista?';
          data.title = 'Atención';
          this.customConfimDialog.confirmDialog(data);
        }
        this.closeEvent.emit();
        break;
      case this.CONSTANTS.ACTION_MAXIMISE:
        this.isFullScreen = true;
        this.maximiseEvent.emit();
        break;
      case this.CONSTANTS.ACTION_MINIMISE:
        this.isFullScreen = false;
        this.minimiseEvent.emit();
        break;
    }
  }

  private navigateInit() {
    this.router.navigate(['']);
  }

  clickAction() {
    if (this.validateForm) {
      this.customFormGroup.markAllAsTouched();
      this.actionPrimaryEvent.emit(this.customFormGroup.valid);
    } else {
      this.actionPrimaryEvent.emit(true);
    }
  }
}
