import { TestBed } from '@angular/core/testing';

import { CargoManagerService } from './cargo-manager.service';

describe('CargoManagerService', () => {
  let service: CargoManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CargoManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
