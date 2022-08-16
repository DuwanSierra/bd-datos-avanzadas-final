import { AreaInteresRequest } from './area-interes.request';
import { FacultyRequest } from './faculty.request';
import { ProfessorRequest } from './professor.request';

export class GrupoInvestigacionRequest {
  facultad?: FacultyRequest;
  nombreGrupoInvestigacion?: string;
  codigoGrupoInvestigacion?: number;
  areaInteres?: AreaInteresRequest;
  profesor?: ProfessorRequest;
}
