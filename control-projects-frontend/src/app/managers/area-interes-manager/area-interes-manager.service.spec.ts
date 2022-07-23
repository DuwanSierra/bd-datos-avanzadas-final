import { TestBed } from '@angular/core/testing';

import { AreaInteresManagerService } from './area-interes-manager.service';

describe('AreaInteresManagerService', () => {
  let service: AreaInteresManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AreaInteresManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
