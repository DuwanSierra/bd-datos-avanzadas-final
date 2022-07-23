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
  //Inputs
  @Input() hint?: string;
  @Input() label?: string;
  @Input() type?: string = 'text';
  @Input() customFormGroup: FormGroup = new FormGroup({});
  @Input() typesControl?: T;
  @Input() isRequired = false;
  @Input() pattern?: string;
  @Input() maxLength?: number;
  @Input() minLength?: number;

  //Variables
  public id: string = Utils.generateUUID();
  public errorHint: string = 'Error';
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
      if (this.pattern) {
        validatorsApplyControl.push(Validators.pattern(this.pattern));
      }
      if (this.maxLength) {
        validatorsApplyControl.push(Validators.maxLength(this.maxLength));
      }
      if (this.minLength) {
        validatorsApplyControl.push(Validators.minLength(this.minLength));
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

  get getErrorMessage(): string {
    if (this.customFormGroup.get(this.id)?.errors) {
      this.errorHint = Utils.getErrorControl(
        Object.keys(this.customFormGroup.get(this.id)?.errors || {})
      );
    }
    return this.errorHint;
  }

  private changeFormGroup(formGroupNew: FormGroup) {
    this.customFormGroup = formGroupNew;
    this.initializeForm();
  }
}
