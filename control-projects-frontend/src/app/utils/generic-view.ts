import { FormGroup } from '@angular/forms';
import { GenericConstants } from './general.constants';

export class GenericView {
  public GENERAL_CONSTANTS = GenericConstants;

  viewFormGroup: FormGroup = new FormGroup({});
}
