import { TestBed } from '@angular/core/testing';

import { CreateInvestigationGroupService } from './create-investigation-group.service';

describe('CreateInvestigationGroupService', () => {
  let service: CreateInvestigationGroupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateInvestigationGroupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
