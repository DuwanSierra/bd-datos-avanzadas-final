import { GrupoInvestigacionRequest } from './grupo-investigacion.request';

export class ProyectoInvestigacionRequest {
  grupoInvestigacion?: GrupoInvestigacionRequest;
  codigo?: number;
  nombre?: string;
  presupuesto?: number;
  fechaInicio?: Date;
  fechaTerminacion?: Date;
}
