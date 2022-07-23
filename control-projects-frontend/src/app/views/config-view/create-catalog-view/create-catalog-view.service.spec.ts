import { TestBed } from '@angular/core/testing';

import { CreateCatalogViewService } from './create-catalog-view.service';

describe('CreateCatalogViewService', () => {
  let service: CreateCatalogViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateCatalogViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
