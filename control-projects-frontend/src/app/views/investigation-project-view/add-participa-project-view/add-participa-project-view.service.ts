import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { ParticipaManagerService } from 'src/app/managers/participa-manager/participa-manager.service';
import { ParticipaRequest } from 'src/app/managers/request-dto/participa.request';

@Injectable({
  providedIn: 'root',
})
export class AddParticipaProjectViewService {
  public participaRequestDto = new BehaviorSubject<ParticipaRequest>(
    new ParticipaRequest()
  );

  constructor(
    private participaManager: ParticipaManagerService,
    private router: Router
  ) {}

  public createParticipa(participa: ParticipaRequest) {
    this.participaManager.createParticipa(participa).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['investigation-project/list']);
    });
  }

  public editParticipa(grupo: ParticipaRequest) {
    grupo.profesor = this.participaRequestDto.value.profesor;
    grupo.proyecto = this.participaRequestDto.value.proyecto;
    this.participaManager.editParticipa(grupo).subscribe((res) => {
      this.resetAll();
      this.router.navigate(['investigation-project/list']);
    });
  }

  public findParticipa(
    grupoNombre: string,
    grupoCodigo: number,
    codigoProyecto: number,
    cedulaProfesor: number
  ) {
    this.participaManager
      .findParticipa(grupoNombre, grupoCodigo, codigoProyecto, cedulaProfesor)
      .subscribe((res: ParticipaRequest) => {
        this.participaRequestDto.next(res);
      });
  }

  public resetAll() {
    this.participaRequestDto.next(new ParticipaRequest());
  }
}
