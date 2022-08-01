import { TestBed } from '@angular/core/testing';

import { SedeManagerService } from './sede-manager.service';

describe('SedeManagerService', () => {
  let service: SedeManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SedeManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
