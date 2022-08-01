import { TestBed } from '@angular/core/testing';

import { CreateSedeViewService } from './create-sede-view.service';

describe('CreateSedeViewService', () => {
  let service: CreateSedeViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateSedeViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
