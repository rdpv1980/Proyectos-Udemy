INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES('rommer','12345',1,'Rommer','Pascacio','rdpv1980@gmail.com');
INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES('andres','12345',1,'Andres','Guzman','profesor@gmail.com');


INSERT INTO rol (nombre) VALUES('ROL_USER');
INSERT INTO rol (nombre) VALUES('ROL_ADMIN');

INSERT INTO usuarios_rol (usuario_id,rol_id) VALUES(1,1);
INSERT INTO usuarios_rol (usuario_id,rol_id) VALUES(2,2);
INSERT INTO usuarios_rol (usuario_id,rol_id) VALUES(2,1);