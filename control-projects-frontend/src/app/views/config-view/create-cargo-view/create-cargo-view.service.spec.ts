import { TestBed } from '@angular/core/testing';

import { CreateCargoViewService } from './create-cargo-view.service';

describe('CreateCargoViewService', () => {
  let service: CreateCargoViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateCargoViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
