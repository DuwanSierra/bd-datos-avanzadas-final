import { TestBed } from '@angular/core/testing';

import { GrupoInvestigacionManagerService } from './grupo-investigacion-manager.service';

describe('GrupoInvestigacionManagerService', () => {
  let service: GrupoInvestigacionManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GrupoInvestigacionManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
