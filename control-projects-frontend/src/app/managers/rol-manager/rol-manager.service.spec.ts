import { TestBed } from '@angular/core/testing';

import { RolManagerService } from './rol-manager.service';

describe('RolManagerService', () => {
  let service: RolManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RolManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
