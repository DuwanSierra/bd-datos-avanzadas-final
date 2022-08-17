CREATE
OR REPLACE VIEW VISTA_PROYECTO_ESTADO AS
select
    DISTINCT proy.codigo_proyecto as id,
    proy.codigo_proyecto as codigoproyecto,
    proy.nombre as nombreproyecto,
    proy.fecha_inicio as fechainicio,
    proy.fecha_terminacion as fechaterminacion,
    CASE 
        WHEN CURRENT_DATE BETWEEN proy.fecha_inicio AND proy.fecha_terminacion THEN 'Activo'
        ELSE 'Inactivo'
    END as estado
from
    proyecto_investigacion proy