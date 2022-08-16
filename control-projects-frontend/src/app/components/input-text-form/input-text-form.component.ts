import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
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
  @Input() model?: any;
  @Input() addMarginBottom = true;
  @Input() rightIcon = '';
  @Input() rightIconTooltip = '';
  @Input() placeHolder = '';
  @Input() disabled = false;
  @Input() controlName: string = Utils.generateUUID();
  @Output() modelChange = new EventEmitter();
  @Output() controlNameChange = new EventEmitter();
  @Output() rightIconEvent = new EventEmitter();
  @Output() focusOutEvent = new EventEmitter();

  //Variables
  public errorHint: string = 'Error';
  constructor() {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {
    if (this.customFormGroup && !this.customFormGroup?.get(this.controlName)) {
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
        this.controlName,
        new FormControl<any>('', validatorsApplyControl)
      );
      if (this.disabled) {
        this.customFormGroup.get(this.controlName)?.disable();
      }
      this.controlNameChange.emit(this.controlName);
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['formGroup']?.currentValue) {
      this.changeFormGroup(changes['formGroup']?.currentValue);
    }
    if (changes['disabled']?.currentValue) {
      this.disabledChanges(); 
    }
  }

  disabledChanges(){
    if(this.customFormGroup?.get(this.controlName)){
      this.customFormGroup.get(this.controlName)?.disable();
    }
  }

  get getErrorMessage(): string {
    if (this.customFormGroup.get(this.controlName)?.errors) {
      this.errorHint = Utils.getErrorControl(
        Object.keys(this.customFormGroup.get(this.controlName)?.errors || {})
      );
    }
    return this.errorHint;
  }

  modelHasBeenChanged(event: any) {
    this.model = event;
    this.modelChange.emit(event);
  }

  focusOutEmit() {
    this.focusOutEvent.emit(this.model);
  }

  rightIconEmit() {
    this.rightIconEvent.emit();
  }

  private changeFormGroup(formGroupNew: FormGroup) {
    this.customFormGroup = formGroupNew;
    this.initializeForm();
  }
}
