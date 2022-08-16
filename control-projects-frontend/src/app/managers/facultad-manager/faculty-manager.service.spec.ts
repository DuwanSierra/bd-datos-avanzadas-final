import { TestBed } from '@angular/core/testing';

import { FacultyManagerService } from './faculty-manager.service';

describe('FacultyManagerService', () => {
  let service: FacultyManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FacultyManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
