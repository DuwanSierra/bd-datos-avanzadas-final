import { TestBed } from '@angular/core/testing';

import { CustomConfimDialogService } from './custom-confim-dialog.service';

describe('CustomConfimDialogService', () => {
  let service: CustomConfimDialogService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomConfimDialogService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
