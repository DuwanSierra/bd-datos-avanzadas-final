import { TestBed } from '@angular/core/testing';

import { CreateInvestigationProjectViewService } from './create-investigation-project-view.service';

describe('CreateInvestigationProjectViewService', () => {
  let service: CreateInvestigationProjectViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateInvestigationProjectViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
