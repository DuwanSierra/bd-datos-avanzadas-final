import { TestBed } from '@angular/core/testing';

import { ProfesorManagerService } from './profesor-manager.service';

describe('ProfesorManagerService', () => {
  let service: ProfesorManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfesorManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
