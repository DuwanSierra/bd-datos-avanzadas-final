import { TestBed } from '@angular/core/testing';

import { ParticipaManagerService } from './participa-manager.service';

describe('ParticipaManagerService', () => {
  let service: ParticipaManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParticipaManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
