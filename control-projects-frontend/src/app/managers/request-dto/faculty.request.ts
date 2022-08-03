import { PhoneRequest } from './phone.request';
import { ProfessorRequest } from './professor.request';
import { SedeRequest } from './sede.request';

export class FacultyRequest {
  nombre?: string;
  sede?: SedeRequest;
  telefonos?: PhoneRequest[];
  decanoActual?: ProfessorRequest;
}
