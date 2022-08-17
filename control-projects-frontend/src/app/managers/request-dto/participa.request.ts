import { ProfessorRequest } from './professor.request';
import { ProyectoInvestigacionRequest } from './proyecto-investigacion.request';
import { RolRequest } from './rol.request';

export class ParticipaRequest {
  profesor?: ProfessorRequest;
  proyecto?: ProyectoInvestigacionRequest;
  rol?: RolRequest;
}
