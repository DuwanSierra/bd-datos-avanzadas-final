import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Utils } from 'src/app/utils/utils';

@Component({
  selector: 'custom-multiple-input-text',
  templateUrl: './custom-multiple-input-text.component.html',
  styleUrls: ['./custom-multiple-input-text.component.scss'],
})
export class CustomMultipleInputTextComponent<T> implements OnInit {
  @Input() labelButton = 'Añadir';
  @Input() labelInput = '';
  @Input() tooltipRemoveIcon = 'Quitar';
  @Input() maxItems = 50;
  @Input() toolTipMaxItems = '';
  @Input() hint?: string;
  @Input() label?: string;
  @Input() type?: string = 'text';
  @Input() customFormGroup: FormGroup = new FormGroup({});
  @Input() typesControl?: T;
  @Input() isRequired = false;
  @Input() pattern?: string;
  @Input() placeHolder: string = '';
  @Input() maxLength?: number;
  @Input() minLength?: number;
  @Input() model?: any[] = [
    {
      id: 0,
      value: '',
    },
  ];

  @Output() modelChange = new EventEmitter();

  controlName: string = Utils.generateUUID();
  controls: any[] = [];
  constructor() {}

  ngOnInit(): void {}
  addControl() {
    if (this.model && this.model.length < this.maxItems) {
      this.model.push('');
    }
  }

  removeItem(position: any) {
    let control = this.controls.find(
      (control) => control.position === position
    );
    if (control?.id && this.customFormGroup.get(control.id) && this.model) {
      this.customFormGroup.removeControl(control.id);
      this.model.splice(position, 1);
      this.controls.slice(this.controls.indexOf(control), 1);
    }
  }

  addModel(position: number, model: any) {
    if (this.model && this.model[position]) {
      this.model[position].value = model;
      this.modelChange.emit(this.model);
    }
  }

  addControls(position: number, id: string) {
    if (this.controls.find((control) => control.position === position)) {
      this.controls[position] = {
        position,
        id,
      };
    } else {
      this.controls.push({
        position,
        id,
      });
    }
  }
}
