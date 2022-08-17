--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3 (Debian 14.3-1.pgdg110+1)
-- Dumped by pg_dump version 14.3 (Debian 14.3-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: area_interes; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.area_interes (
    id_area_interes bigint NOT NULL,
    area_interes character varying(70) NOT NULL
);


ALTER TABLE public.area_interes OWNER TO root;

--
-- Name: cargo; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.cargo (
    id_cargo bigint NOT NULL,
    cargo character varying(70) NOT NULL
);


ALTER TABLE public.cargo OWNER TO root;

--
-- Name: facultad; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.facultad (
    nombre_facultad character varying(255) NOT NULL,
    fk_id_sede bigint NOT NULL
);


ALTER TABLE public.facultad OWNER TO root;

--
-- Name: grupo_investigacion; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.grupo_investigacion (
    codigo_grupo character varying(255) NOT NULL,
    nombre_grupo character varying(255) NOT NULL,
    fk_id_area_interes bigint NOT NULL,
    fk_nombre_facultad character varying(255) NOT NULL,
    fk_cedula_profesor bigint NOT NULL
);


ALTER TABLE public.grupo_investigacion OWNER TO root;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO root;

--
-- Name: participa; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.participa (
    cedula_profesor bigint NOT NULL,
    codigo_proyecto character varying(255) NOT NULL,
    codigo_grupo character varying(255) NOT NULL,
    nombre_grupo character varying(255) NOT NULL,
    fk_id_rol bigint
);


ALTER TABLE public.participa OWNER TO root;

--
-- Name: profesor; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.profesor (
    cedula_profesor bigint NOT NULL,
    experiencia_inv date NOT NULL,
    nombre character varying(70) NOT NULL,
    fk_id_cargo bigint NOT NULL,
    fk_nombre_facultad character varying(255) NOT NULL
);


ALTER TABLE public.profesor OWNER TO root;

--
-- Name: proyecto_investigacion; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.proyecto_investigacion (
    codigo_proyecto character varying(255) NOT NULL,
    fecha_inicio timestamp without time zone NOT NULL,
    fecha_terminacion timestamp without time zone NOT NULL,
    nombre character varying(70) NOT NULL,
    valor_pres numeric(19,2) NOT NULL,
    codigo_grupo character varying(255) NOT NULL,
    nombre_grupo character varying(255) NOT NULL
);


ALTER TABLE public.proyecto_investigacion OWNER TO root;

--
-- Name: reporte_proyecto_profesor_view; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.reporte_proyecto_profesor_view (
    id bigint NOT NULL,
    cedulaprofesor bigint,
    codigogrupo character varying(255),
    codigoproyecto character varying(255),
    nombregrupo character varying(255),
    nombreprofesor character varying(255),
    nombreproyecto character varying(255)
);


ALTER TABLE public.reporte_proyecto_profesor_view OWNER TO root;

--
-- Name: rol; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.rol (
    rol_id bigint NOT NULL,
    rol character varying(70) NOT NULL
);


ALTER TABLE public.rol OWNER TO root;

--
-- Name: sede; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.sede (
    id_sede bigint NOT NULL,
    sede character varying(70)
);


ALTER TABLE public.sede OWNER TO root;

--
-- Name: telefono; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.telefono (
    nombre_facultad character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL
);


ALTER TABLE public.telefono OWNER TO root;

--
-- Name: titulo; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.titulo (
    cedula_profesor bigint NOT NULL,
    titulo character varying(255) NOT NULL
);


ALTER TABLE public.titulo OWNER TO root;

--
-- Data for Name: area_interes; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.area_interes (id_area_interes, area_interes) FROM stdin;
\.


--
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.cargo (id_cargo, cargo) FROM stdin;
\.


--
-- Data for Name: facultad; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.facultad (nombre_facultad, fk_id_sede) FROM stdin;
\.


--
-- Data for Name: grupo_investigacion; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.grupo_investigacion (codigo_grupo, nombre_grupo, fk_id_area_interes, fk_nombre_facultad, fk_cedula_profesor) FROM stdin;
\.


--
-- Data for Name: participa; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.participa (cedula_profesor, codigo_proyecto, codigo_grupo, nombre_grupo, fk_id_rol) FROM stdin;
\.


--
-- Data for Name: profesor; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.profesor (cedula_profesor, experiencia_inv, nombre, fk_id_cargo, fk_nombre_facultad) FROM stdin;
\.


--
-- Data for Name: proyecto_investigacion; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.proyecto_investigacion (codigo_proyecto, fecha_inicio, fecha_terminacion, nombre, valor_pres, codigo_grupo, nombre_grupo) FROM stdin;
\.


--
-- Data for Name: reporte_proyecto_profesor_view; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.reporte_proyecto_profesor_view (id, cedulaprofesor, codigogrupo, codigoproyecto, nombregrupo, nombreprofesor, nombreproyecto) FROM stdin;
\.


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.rol (rol_id, rol) FROM stdin;
\.


--
-- Data for Name: sede; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.sede (id_sede, sede) FROM stdin;
\.


--
-- Data for Name: telefono; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.telefono (nombre_facultad, telefono) FROM stdin;
\.


--
-- Data for Name: titulo; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.titulo (cedula_profesor, titulo) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: area_interes area_interes_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.area_interes
    ADD CONSTRAINT area_interes_pkey PRIMARY KEY (id_area_interes);


--
-- Name: cargo cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id_cargo);


--
-- Name: facultad facultad_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.facultad
    ADD CONSTRAINT facultad_pkey PRIMARY KEY (nombre_facultad);


--
-- Name: grupo_investigacion grupo_investigacion_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.grupo_investigacion
    ADD CONSTRAINT grupo_investigacion_pkey PRIMARY KEY (codigo_grupo, nombre_grupo);


--
-- Name: participa participa_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.participa
    ADD CONSTRAINT participa_pkey PRIMARY KEY (cedula_profesor, codigo_proyecto, codigo_grupo, nombre_grupo);


--
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (cedula_profesor);


--
-- Name: proyecto_investigacion proyecto_investigacion_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.proyecto_investigacion
    ADD CONSTRAINT proyecto_investigacion_pkey PRIMARY KEY (codigo_proyecto, codigo_grupo, nombre_grupo);


--
-- Name: reporte_proyecto_profesor_view reporte_proyecto_profesor_view_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.reporte_proyecto_profesor_view
    ADD CONSTRAINT reporte_proyecto_profesor_view_pkey PRIMARY KEY (id);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (rol_id);


--
-- Name: sede sede_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.sede
    ADD CONSTRAINT sede_pkey PRIMARY KEY (id_sede);


--
-- Name: telefono telefono_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.telefono
    ADD CONSTRAINT telefono_pkey PRIMARY KEY (nombre_facultad, telefono);


--
-- Name: titulo titulo_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.titulo
    ADD CONSTRAINT titulo_pkey PRIMARY KEY (cedula_profesor, titulo);


--
-- Name: idx_areainteresentity_area_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_areainteresentity_area_id ON public.area_interes USING btree (id_area_interes);


--
-- Name: idx_cargo_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_cargo_id ON public.cargo USING btree (id_cargo);


--
-- Name: idx_cedula_profesor; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_cedula_profesor ON public.profesor USING btree (cedula_profesor);


--
-- Name: idx_codigogrupo_participa_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_codigogrupo_participa_id ON public.participa USING btree (codigo_grupo);


--
-- Name: idx_codigoproyecto_participa_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_codigoproyecto_participa_id ON public.participa USING btree (codigo_proyecto);


--
-- Name: idx_facultad_nombre; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_facultad_nombre ON public.facultad USING btree (nombre_facultad);


--
-- Name: idx_grupo_investigacion_codigo_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_grupo_investigacion_codigo_id ON public.grupo_investigacion USING btree (codigo_grupo);


--
-- Name: idx_grupo_investigacion_nombre_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_grupo_investigacion_nombre_id ON public.grupo_investigacion USING btree (nombre_grupo);


--
-- Name: idx_grupo_nombre_proyecto_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_grupo_nombre_proyecto_id ON public.proyecto_investigacion USING btree (nombre_grupo);


--
-- Name: idx_grupo_proyecto_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_grupo_proyecto_id ON public.proyecto_investigacion USING btree (codigo_grupo);


--
-- Name: idx_nombregrupo_participa_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_nombregrupo_participa_id ON public.participa USING btree (nombre_grupo);


--
-- Name: idx_profesor_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_profesor_id ON public.titulo USING btree (cedula_profesor);


--
-- Name: idx_profesor_participa_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_profesor_participa_id ON public.participa USING btree (cedula_profesor);


--
-- Name: idx_rol_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_rol_id ON public.rol USING btree (rol_id);


--
-- Name: idx_sede_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_sede_id ON public.sede USING btree (sede);


--
-- Name: idx_telefono_facultad; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_telefono_facultad ON public.telefono USING btree (nombre_facultad);


--
-- Name: idx_telefono_telefono; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_telefono_telefono ON public.telefono USING btree (telefono);


--
-- Name: idx_titulo_id; Type: INDEX; Schema: public; Owner: root
--

CREATE INDEX idx_titulo_id ON public.titulo USING btree (titulo);


--
-- Name: facultad fk_facultad_sede; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.facultad
    ADD CONSTRAINT fk_facultad_sede FOREIGN KEY (fk_id_sede) REFERENCES public.sede(id_sede);


--
-- Name: grupo_investigacion fk_grupo_investigacion_area_interes; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.grupo_investigacion
    ADD CONSTRAINT fk_grupo_investigacion_area_interes FOREIGN KEY (fk_id_area_interes) REFERENCES public.area_interes(id_area_interes);


--
-- Name: grupo_investigacion fk_grupo_investigacion_facultad; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.grupo_investigacion
    ADD CONSTRAINT fk_grupo_investigacion_facultad FOREIGN KEY (fk_nombre_facultad) REFERENCES public.facultad(nombre_facultad);


--
-- Name: grupo_investigacion fk_grupo_investigacion_profesor; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.grupo_investigacion
    ADD CONSTRAINT fk_grupo_investigacion_profesor FOREIGN KEY (fk_cedula_profesor) REFERENCES public.profesor(cedula_profesor);


--
-- Name: participa fk_participa_profesor; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.participa
    ADD CONSTRAINT fk_participa_profesor FOREIGN KEY (cedula_profesor) REFERENCES public.profesor(cedula_profesor);


--
-- Name: participa fk_participa_proyecto; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.participa
    ADD CONSTRAINT fk_participa_proyecto FOREIGN KEY (codigo_proyecto, codigo_grupo, nombre_grupo) REFERENCES public.proyecto_investigacion(codigo_proyecto, codigo_grupo, nombre_grupo);


--
-- Name: participa fk_participa_rol; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.participa
    ADD CONSTRAINT fk_participa_rol FOREIGN KEY (fk_id_rol) REFERENCES public.rol(rol_id);


--
-- Name: profesor fk_profesor_cargo; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT fk_profesor_cargo FOREIGN KEY (fk_id_cargo) REFERENCES public.cargo(id_cargo);


--
-- Name: profesor fk_profesor_facultad; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT fk_profesor_facultad FOREIGN KEY (fk_nombre_facultad) REFERENCES public.facultad(nombre_facultad);


--
-- Name: proyecto_investigacion fk_proyecto_investigacion_grupo; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.proyecto_investigacion
    ADD CONSTRAINT fk_proyecto_investigacion_grupo FOREIGN KEY (codigo_grupo, nombre_grupo) REFERENCES public.grupo_investigacion(codigo_grupo, nombre_grupo);


--
-- Name: telefono fk_telefono_facultad; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.telefono
    ADD CONSTRAINT fk_telefono_facultad FOREIGN KEY (nombre_facultad) REFERENCES public.facultad(nombre_facultad);


--
-- Name: titulo fk_titulo_profesor; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.titulo
    ADD CONSTRAINT fk_titulo_profesor FOREIGN KEY (cedula_profesor) REFERENCES public.profesor(cedula_profesor);


--
-- PostgreSQL database dump complete
--

