import { PhoneRequest } from './phone.request';
import { SedeRequest } from './sede.request';

export class FacultyRequest {
  facultadNombre?: string;
  sede?: SedeRequest;
  telefonos?: PhoneRequest[];
}
