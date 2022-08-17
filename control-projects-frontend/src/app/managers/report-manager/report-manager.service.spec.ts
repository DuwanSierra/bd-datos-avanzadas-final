import { TestBed } from '@angular/core/testing';

import { ReportManagerService } from './report-manager.service';

describe('ReportManagerService', () => {
  let service: ReportManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReportManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
