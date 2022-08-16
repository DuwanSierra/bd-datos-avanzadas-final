import { TestBed } from '@angular/core/testing';

import { ProyectoInvestigacionManagerService } from './proyecto-investigacion-manager.service';

describe('ProyectoInvestigacionManagerService', () => {
  let service: ProyectoInvestigacionManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProyectoInvestigacionManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
