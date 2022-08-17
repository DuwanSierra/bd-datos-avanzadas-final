--Create reports
CREATE
OR REPLACE VIEW VISTA_DETERMINADO_PROFESOR_PROYECTO AS
select
    ROW_NUMBER () OVER (
           ORDER BY proy.codigo_proyecto
        ) as id,
    proy.codigo_grupo as codigogrupo,
    proy.nombre_grupo as nombregrupo,
    proy.codigo_proyecto as codigoproyecto,
    proy.nombre as nombreproyecto,
    prof.cedula_profesor as cedulaprofesor,
    prof.nombre as nombreprofesor
from
    participa p
    inner join proyecto_investigacion proy on p.codigo_proyecto = proy.codigo_proyecto
    inner join proyecto_investigacion proy2 on p.nombre_grupo = proy2.nombre_grupo
    inner join proyecto_investigacion proy3 on p.codigo_grupo = proy3.codigo_grupo
    inner join profesor prof on p.cedula_profesor = prof.cedula_profesor
