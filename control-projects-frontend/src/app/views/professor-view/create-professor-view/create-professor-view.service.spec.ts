import { TestBed } from '@angular/core/testing';

import { CreateProfessorViewService } from './create-professor-view.service';

describe('CreateProfessorViewService', () => {
  let service: CreateProfessorViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateProfessorViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
