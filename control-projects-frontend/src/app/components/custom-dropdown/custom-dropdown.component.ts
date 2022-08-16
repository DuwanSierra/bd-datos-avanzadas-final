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
import { LazyLoadEvent } from 'primeng/api';
import { Utils } from 'src/app/utils/utils';
import { CustomTablePaginateDto } from '../custom-table/custom-table.paginate.dto';
import { CustomTablePaginatorDto } from '../custom-table/custom-table.paginator.dto';

@Component({
  selector: 'custom-dropdown',
  templateUrl: './custom-dropdown.component.html',
  styleUrls: ['./custom-dropdown.component.scss'],
})
export class CustomDropdownComponent implements OnInit, OnChanges {

  //Inputs
  @Input() placeholder = 'Selecciona un item';
  @Input() service: any;
  @Input() methodGetData: any;
  @Input() data: any[] = [];
  @Input() size = 10;
  @Input() keysToShow: string[] = [];
  @Input() label = '';
  @Input() isRequired = false;
  @Input() customFormGroup: FormGroup = new FormGroup({});
  @Input() hint?: string;
  @Input() model: any;

  //outputs
  @Output() modelChange = new EventEmitter();

  public id: string = Utils.generateUUID();
  public errorHint: string = 'Error';

  loading = false;
  isLast = false;

  constructor() {}

  ngOnInit(): void {
    this.initializeForm();
  }
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['formGroup']?.currentValue) {
      this.changeFormGroup(changes['formGroup']?.currentValue);
    }
    if (changes['model']?.currentValue){
      this.setData();
    }
  }

  setData(){
    if(this.data.length === 0){
      this.data.push(this.model);
    }
  }

  loadData(event: any) {
    if (this.service && this.methodGetData && !this.isLast) {
      this.loading = true;
      let paginate = new CustomTablePaginateDto();
      paginate.size = this.size;
      paginate.page = Math.ceil(
        ((event.first || 1) - 1) / (paginate.size || 5)
      );
      this.service[this.methodGetData](paginate)?.subscribe(
        (res: CustomTablePaginatorDto) => {
          this.data = this.data.concat(res.content);
          this.isLast = res.last;
          this.loading = false;
        }
      );
    }
  }

  getText(item: any): string {
    let text = '';
    this.keysToShow.forEach((key) => {
      text = `${text} ${item[key] || ''}`;
    });
    return text;
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

  selectItem(item: any){
    this.model = item;
    this.modelChange.emit(this.model);
  }
}
