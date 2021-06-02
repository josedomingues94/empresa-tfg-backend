INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('51133615S', 'Jose', 'Domingues', 'Gordillo', '1994-05-28', 'jose@gmail.com',1);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('41594759H', 'Elia', 'Dotor', 'Puente', '1991-03-21', 'elia@gmail.com',2);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('86140537V', 'Fatima', 'Gordillo', 'Dominguez', '1995-03-27', 'fatima@gmail.com',1);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('53652910M', 'Javier', 'Serrato', 'Jimenez', '1991-08-14', 'javier@gmail.com',2);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('57971451C', 'Giulia', 'Garcia', 'Gil', '1990-04-02', 'giulia@gmail.com',3);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('59146104V', 'Sara', 'Sanchez', 'Gonzalez', '1996-01-30', 'sara@gmail.com',1);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('52579634S', 'Paula', 'Montero', 'Sanchez', '1992-12-07', 'paula@gmail.com',4);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('50457492Y', 'Francisco', 'Roales', 'Fernandez', '1990-10-09', 'francisco@gmail.com',4);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('58218387M', 'Luis', 'Izquierdo', 'Lopez', '1974-02-20', 'luis@gmail.com',5);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('56961108K', 'Hector', 'Rodriguez', 'Ramos', '1994-09-20', 'hector@gmail.com',1);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('55633232G', 'Sergio', 'Torres', 'Martinez', '1995-11-19', 'sergio@gmail.com',5);
INSERT INTO empleados (dni, nombre, apellido1, apellido2, create_at, email, oficina_id) VALUES('55809842C', 'Oscar', 'Alonso', 'Monje', '1993-02-04', 'oscar@gmail.com',6);

INSERT INTO usuarios (username, password, enabled, nombre, apellidos, email) VALUES ('jose','$2a$10$eG9PhXVnpslXzh.FHiVE5OhkX33lawK/65fl6rooSJCe5xcsF7tF.',1,'Jose','Domingues','jose@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellidos, email) VALUES ('admin','$2a$10$nV7wqMYsJ9I/OLg0AnOauOjWT5ELkT2YcSc0jVEGPx217FM0FmvTW',1,'Javier','Serrato','javier@gmail.com');


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);