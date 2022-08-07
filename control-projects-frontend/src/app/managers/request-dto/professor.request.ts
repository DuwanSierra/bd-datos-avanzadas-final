import { GrupoInvestigacionRequest } from "./grupo-investigacion.request";

export class ProfessorRequest {
    cedula?: number;
    nombreProfesor?:string;
    inicioInvestigacion?: Date;
    grupoInvestigacion?: GrupoInvestigacionRequest;
}
