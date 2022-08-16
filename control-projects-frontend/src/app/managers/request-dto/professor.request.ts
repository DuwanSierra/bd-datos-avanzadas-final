import { CargoRequest } from './cargo.request';
import { FacultyRequest } from './faculty.request';
import { TituloRequest } from './titulo.request';

export class ProfessorRequest {
  cedulaProfesor?: number;
  nombreProfesor?: string;
  inicioInvestigacion?: Date;
  aniosInvestigacion?: number;
  facultad?: FacultyRequest;
  cargo?: CargoRequest;
  titulos?: TituloRequest[];
}
