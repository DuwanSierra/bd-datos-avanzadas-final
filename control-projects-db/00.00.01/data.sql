--Data Dummy table area interes
insert into area_interes (area_id, area_nombre) values (1, 'Services');
insert into area_interes (area_id, area_nombre) values (2, 'Marketing');
insert into area_interes (area_id, area_nombre) values (3, 'Services');
insert into area_interes (area_id, area_nombre) values (4, 'Sales');
insert into area_interes (area_id, area_nombre) values (5, 'Business Development');
insert into area_interes (area_id, area_nombre) values (6, 'Sales');
insert into area_interes (area_id, area_nombre) values (7, 'Accounting');
insert into area_interes (area_id, area_nombre) values (8, 'Services');
insert into area_interes (area_id, area_nombre) values (9, 'Digital Services');
insert into area_interes (area_id, area_nombre) values (10, 'Research and Development');


--Data Dummy table sede
insert into sede (sede_id, codigo, direccion, nombre) values (1, '9151', '7 Lunder Lane', 'Frami-Hahn');
insert into sede (sede_id, codigo, direccion, nombre) values (2, '0372', '88 Transport Alley', 'Cronin, Kuhlman and Rippin');
insert into sede (sede_id, codigo, direccion, nombre) values (3, '6509', '94 Daystar Avenue', 'Bahringer Group');
insert into sede (sede_id, codigo, direccion, nombre) values (4, '6551', '7699 Larry Plaza', 'Willms Group');
insert into sede (sede_id, codigo, direccion, nombre) values (5, '5284', '034 Nancy Drive', 'Ritchie Group');
insert into sede (sede_id, codigo, direccion, nombre) values (6, '9045', '7941 Emmet Road', 'Weimann Inc');
insert into sede (sede_id, codigo, direccion, nombre) values (7, '7730', '71476 Mendota Center', 'Morar, Metz and Hilpert');
insert into sede (sede_id, codigo, direccion, nombre) values (8, '7091', '000 Daystar Street', 'Ondricka, Feest and Wolff');
insert into sede (sede_id, codigo, direccion, nombre) values (9, '8035', '5 Linden Trail', 'Monahan, Jacobs and Ferry');
insert into sede (sede_id, codigo, direccion, nombre) values (10, '9396', '092 Melvin Lane', 'Leannon, Donnelly and Auer');

--Data Dummy table facultad
insert into facultad (facultad_nombre, sede_id) values ('Facultad Tecnologica', 1);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Ingenieria', 2);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Ciencias Sociales', 3);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Medicina', 4);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Derecho', 5);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Matemáticas', 6);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Quimica', 7);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Música', 8);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Artes', 9);
insert into facultad (facultad_nombre, sede_id) values ('Facultad Ingenieria Aeroespacial', 10);

--Data Dummy table profesor
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('8815052232', '2020-05-01T04:12:19Z', 'Bil Shalcros');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('8730286271', '2019-10-11T01:24:30Z', 'Tracie Farans');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('1967937451', '2021-10-03T18:13:44Z', 'Lorilee McLarnon');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('3787137874', '2020-02-29T23:30:11Z', 'Doralynn Sucre');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('1748688421', '2022-03-08T02:55:42Z', 'Shirley Catterall');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('9072414578', '2022-04-25T21:46:56Z', 'Teodora Booler');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('1192217578', '2021-04-19T11:10:56Z', 'Chariot Radwell');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('4520791677', '2021-08-27T00:44:30Z', 'Bobinette Marthen');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('2710549484', '2022-01-17T06:59:14Z', 'Melisa Oswell');
insert into profesor (cedula_profesor, inicio_investigacion, nombre_profesor) values ('3464234169', '2020-09-09T13:19:14Z', 'Clair Moverley');

--Data Dummy table grupo_investigacion

insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (1, 'Scolopax minor', 'Facultad Ingenieria Aeroespacial', 1, 9072414578);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (2, 'Anas platyrhynchos', 'Facultad Tecnologica', 2, 1967937451);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (3, 'Phasianus colchicus', 'Facultad Tecnologica', 3, 3464234169);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (4, 'Oreotragus oreotragus', 'Facultad Ciencias Sociales', 4, 8815052232);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (5, 'Macropus agilis', 'Facultad Ciencias Sociales', 5, 1967937451);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (6, 'Hyaena brunnea', 'Facultad Derecho', 6, 8815052232);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (7, 'Castor fiber', 'Facultad Ingenieria', 7, 2710549484);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (8, 'Papio ursinus', 'Facultad Medicina', 8, 1748688421);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (9, 'Alouatta seniculus', 'Facultad Ingenieria', 9, 3464234169);
insert into grupo_investigacion (codigo_grupo_investigacion, nombre_grupo_investigacion, facultad_nombre, area_interes_area_id, profesor_entity_cedula_profesor) values (10, 'Ursus americanus', 'Facultad Música', 10, 4520791677);

