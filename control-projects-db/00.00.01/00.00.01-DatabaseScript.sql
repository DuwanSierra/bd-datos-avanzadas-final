BEGIN;


CREATE TABLE IF NOT EXISTS public.area_interes
(
    area_id bigint NOT NULL,
    area_nombre character varying(70) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT area_interes_pkey PRIMARY KEY (area_id)
);

CREATE TABLE IF NOT EXISTS public.facultad
(
    facultad_nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    decano_cedula_profesor bigint,
    sede_id bigint NOT NULL,
    CONSTRAINT facultad_pkey PRIMARY KEY (facultad_nombre)
);

CREATE TABLE IF NOT EXISTS public.grupo_investigacion
(
    codigo_grupo_investigacion bigint NOT NULL,
    nombre_grupo_investigacion character varying(255) COLLATE pg_catalog."default" NOT NULL,
    facultad_nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    area_interes_area_id bigint,
    CONSTRAINT grupo_investigacion_pkey PRIMARY KEY (codigo_grupo_investigacion, facultad_nombre, nombre_grupo_investigacion),
    CONSTRAINT idx_grupo_investigacion_codigo_id UNIQUE (codigo_grupo_investigacion),
    CONSTRAINT idx_grupo_investigacion_nombre_id UNIQUE (nombre_grupo_investigacion)
);

CREATE TABLE IF NOT EXISTS public.investigador_proyecto
(
    investigador_proyecto_id bigint NOT NULL,
    fecha_fin_investigacion timestamp without time zone NOT NULL,
    fecha_inicio_investigacion timestamp without time zone NOT NULL,
    rol_desarrolla_investigacion bigint NOT NULL,
    investigador_cedula_profesor bigint,
    proyecto_investigacion_proyecto_id bigint,
    CONSTRAINT investigador_proyecto_pkey PRIMARY KEY (investigador_proyecto_id)
);

CREATE TABLE IF NOT EXISTS public.profesor
(
    cedula_profesor bigint NOT NULL,
    inicio_investigacion timestamp without time zone NOT NULL,
    nombre_profesor character varying(70) COLLATE pg_catalog."default" NOT NULL,
    grupo_investigacion_codigo_grupo_investigacion bigint,
    grupo_investigacion_facultad_nombre character varying(255) COLLATE pg_catalog."default",
    grupo_investigacion_nombre_grupo_investigacion character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT profesor_pkey PRIMARY KEY (cedula_profesor)
);

CREATE TABLE IF NOT EXISTS public.proyecto_investigacion
(
    proyecto_id bigint NOT NULL,
    codigo_proyecto bigint NOT NULL,
    fecha_fin_proyecto timestamp without time zone NOT NULL,
    fecha_inicio_proyecto timestamp without time zone NOT NULL,
    presupuesto_proyecto numeric(19, 2) NOT NULL,
    proyecto_nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    grupo_investigacion_codigo_grupo_investigacion bigint,
    grupo_investigacion_facultad_nombre character varying(255) COLLATE pg_catalog."default",
    grupo_investigacion_nombre_grupo_investigacion character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT proyecto_investigacion_pkey PRIMARY KEY (proyecto_id)
);

CREATE TABLE IF NOT EXISTS public.sede
(
    sede_id bigint NOT NULL,
    codigo character varying(10) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(30) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(70) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sede_pkey PRIMARY KEY (sede_id)
);

CREATE TABLE IF NOT EXISTS public.titulo_profesor
(
    titulo_id bigint NOT NULL,
    nombre_titulo character varying(70) COLLATE pg_catalog."default" NOT NULL,
    profesor_cedula bigint NOT NULL,
    CONSTRAINT titulo_profesor_pkey PRIMARY KEY (titulo_id)
);

ALTER TABLE IF EXISTS public.facultad
    ADD CONSTRAINT fk_facultad_sede FOREIGN KEY (sede_id)
    REFERENCES public.sede (sede_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.facultad
    ADD CONSTRAINT fk_facultad_profesor FOREIGN KEY (decano_cedula_profesor)
    REFERENCES public.profesor (cedula_profesor) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.grupo_investigacion
    ADD CONSTRAINT fk_facultad_area_interes FOREIGN KEY (area_interes_area_id)
    REFERENCES public.area_interes (area_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.grupo_investigacion
    ADD CONSTRAINT fk_grupo_investigacion_facultad FOREIGN KEY (facultad_nombre)
    REFERENCES public.facultad (facultad_nombre) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.investigador_proyecto
    ADD CONSTRAINT fk_investigacion_profesor FOREIGN KEY (investigador_cedula_profesor)
    REFERENCES public.profesor (cedula_profesor) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.investigador_proyecto
    ADD CONSTRAINT fk_proyecto_investigacion_investigador FOREIGN KEY (proyecto_investigacion_proyecto_id)
    REFERENCES public.proyecto_investigacion (proyecto_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.profesor
    ADD CONSTRAINT fk_profesor_facultad FOREIGN KEY (grupo_investigacion_nombre_grupo_investigacion, grupo_investigacion_facultad_nombre, grupo_investigacion_codigo_grupo_investigacion)
    REFERENCES public.grupo_investigacion (nombre_grupo_investigacion, facultad_nombre, codigo_grupo_investigacion) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.proyecto_investigacion
    ADD CONSTRAINT fk_proyecto_investigacion_grupo_investigacion FOREIGN KEY (grupo_investigacion_nombre_grupo_investigacion, grupo_investigacion_facultad_nombre, grupo_investigacion_codigo_grupo_investigacion)
    REFERENCES public.grupo_investigacion (nombre_grupo_investigacion, facultad_nombre, codigo_grupo_investigacion) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.titulo_profesor
    ADD CONSTRAINT fk_titulo_profesor FOREIGN KEY (profesor_cedula)
    REFERENCES public.profesor (cedula_profesor) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;