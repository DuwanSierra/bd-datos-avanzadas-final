import { TestBed } from '@angular/core/testing';

import { CreateRolViewService } from './create-rol-view.service';

describe('CreateRolViewService', () => {
  let service: CreateRolViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateRolViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
