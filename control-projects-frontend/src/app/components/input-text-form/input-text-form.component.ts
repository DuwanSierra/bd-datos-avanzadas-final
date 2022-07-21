import {
  Component,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges,
} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Utils } from 'src/app/utils/utils';

@Component({
  selector: 'input-text-form',
  templateUrl: './input-text-form.component.html',
  styleUrls: ['./input-text-form.component.scss'],
})
export class InputTextFormComponent<T> implements OnInit, OnChanges {
  public id: string = Utils.generateUUID();
  @Input() hint?: string;
  @Input() label?: string;
  @Input() type?: string = 'text';
  @Input() customFormGroup: FormGroup = new FormGroup({});
  @Input() typesControl?: T;
  @Input() isRequired = false;
  constructor() {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {
    if (!this.customFormGroup?.get(this.id)) {
      let validatorsApplyControl = [];
      if (this.isRequired) {
        validatorsApplyControl.push(Validators.required);
      }
      this.customFormGroup.addControl(
        this.id,
        new FormControl<any>('', validatorsApplyControl)
      );
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['formGroup']?.currentValue) {
      this.changeFormGroup(changes['formGroup']?.currentValue);
    }
  }

  private changeFormGroup(formGroupNew: FormGroup) {
    this.customFormGroup = formGroupNew;
    this.initializeForm();
  }
}
