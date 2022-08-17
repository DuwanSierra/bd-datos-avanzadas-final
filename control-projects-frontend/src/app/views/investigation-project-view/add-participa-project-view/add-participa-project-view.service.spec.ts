import { TestBed } from '@angular/core/testing';

import { AddParticipaProjectViewService } from './add-participa-project-view.service';

describe('AddParticipaProjectViewService', () => {
  let service: AddParticipaProjectViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddParticipaProjectViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
