import { TestBed } from '@angular/core/testing';

import { CreateFacultyViewService } from './create-faculty-view.service';

describe('CreateFacultyViewService', () => {
  let service: CreateFacultyViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateFacultyViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
