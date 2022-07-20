import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { BehaviorSubject } from 'rxjs';
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
  
  //Outputs
  @Output() closeEvent = new EventEmitter<boolean>();
  @Output() maximiseEvent = new EventEmitter<boolean>();
  @Output() minimiseEvent = new EventEmitter<boolean>();

  //variables
  public isFullScreen = false;

  public CONSTANTS = WindowConstants;

  constructor() {}

  ngOnInit(): void {}

  buttonAction(action: string) {
    switch (action) {
      case this.CONSTANTS.ACTION_CLOSE:
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
}
