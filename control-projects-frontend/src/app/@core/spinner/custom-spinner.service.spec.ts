import { TestBed } from '@angular/core/testing';

import { CustomSpinnerService } from './custom-spinner.service';

describe('CustomSpinnerService', () => {
  let service: CustomSpinnerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomSpinnerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
