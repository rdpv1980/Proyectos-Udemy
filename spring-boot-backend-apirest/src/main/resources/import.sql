
INSERT INTO regiones (id,nombre) VALUES (1,'Sudamérica');
INSERT INTO regiones (id,nombre) VALUES (2,'Centroamérica');
INSERT INTO regiones (id,nombre) VALUES (3,'Norteamérica');
INSERT INTO regiones (id,nombre) VALUES (4,'Europa');
INSERT INTO regiones (id,nombre) VALUES (5,'Asia');
INSERT INTO regiones (id,nombre) VALUES (6,'Africa');
INSERT INTO regiones (id,nombre) VALUES (7,'OceanÃ­a');
INSERT INTO regiones (id,nombre) VALUES (8,'Antártida');

INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(1,'Andrés','Guzman','profesor@bolsadeideas.com','2020-01-01');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(2,'Mr John','Doe','john.doe@gmail.com','2020-01-02');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(4,'Linus','Torvals','linus.torvals@bgmailcom','2020-01-03');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(4,'Rasmus','Lerdorf','rasmus.lerdorf@gmail.com','2020-01-04');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(4,'Erich','Gamma','erich.gamma@gmail.com','2020-01-05');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(3,'Richard','Helm','richard.helm@gmail.com','2020-01-06');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(3,'Ralph','Johnson','ralph.johson@gmail.com','2020-01-07');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(3,'John','Vlissides','john.vlissides@gmail.com','2020-01-08');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(3,'Dr.James','Gosling','james.gosling@gmail.com','2020-01-09');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(5,'Magma','Lee','magma.lee@gmail.com','2020-01-10');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(6,'Tornado','Roe','tornado.roe@gmail.com','2020-01-11');
INSERT INTO clientes (region_id,nombre, apellido, email,create_at) VALUES(7,'Jade','Doe','jane.doe@gmail.com','2020-01-12');

INSERT INTO usuarios (username, password, enabled,nombre,apellido,email) VALUES ('andres','',1,'Andres','Guzman','profesor@bolsadeideas.com');
INSERT INTO usuarios (username, password, enabled,nombre,apellido,email) VALUES ('admin','',1,'Joe','Guzman','jhoe@bolsadeideas.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (1,2);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,1);

INSERT INTO productos(nombre, precio, create_at) VALUES ('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Mica Comoda 5 Cajones', 299990, NOW());

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_item(cantidad, factura_id, producto_id) VALUES (1,1,1)
INSERT INTO facturas_item(cantidad, factura_id, producto_id) VALUES (2,1,4)
INSERT INTO facturas_item(cantidad, factura_id, producto_id) VALUES (1,1,5)
INSERT INTO facturas_item(cantidad, factura_id, producto_id) VALUES (1,1,7)

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta, 'Alguna nota importante', 1, NOW());
INSERT INTO facturas_item(cantidad, factura_id, producto_id) VALUES (3,2,6)










