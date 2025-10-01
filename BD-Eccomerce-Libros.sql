-- Crear la base de datos (ejecutar solo una vez)
CREATE DATABASE rest_eccomerce_libros;
-- Conectarse a la base de datos
\c RestEccomerceLibros;

CREATE TABLE libro (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  idioma_original VARCHAR(100)
);

CREATE TABLE editorial (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL
);

CREATE TABLE usuario (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  clave VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  direccion VARCHAR(255),
  numero_telefono VARCHAR(20)

);

CREATE TABLE autor (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  nacionalidad VARCHAR(100)
);

CREATE TABLE categoria (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE edicion (
  id SERIAL PRIMARY KEY,
  idioma VARCHAR(100),
  encuadernacion VARCHAR(100),
  dimensiones VARCHAR(100),
  traductor VARCHAR(255),
  fecha_publicacion DATE,
  precio_venta NUMERIC(10,2),
  resumen TEXT,
  id_libro INT REFERENCES libro(id),
  id_editorial INT REFERENCES editorial(id),
  imagen VARCHAR(400)
);

CREATE TABLE venta (
  id SERIAL PRIMARY KEY,
  id_usuario INT REFERENCES usuario(id),
  fecha DATE
);

CREATE TABLE libro_autor (
  id SERIAL PRIMARY KEY,
  id_libro INT REFERENCES libro(id),
  id_autor INT REFERENCES autor(id),
  grado VARCHAR(100)
);

CREATE TABLE libro_categoria (
  id SERIAL PRIMARY KEY,
  id_libro INT REFERENCES libro(id),
  id_categoria INT REFERENCES categoria(id)
);

CREATE TABLE detalle_venta (
  id SERIAL PRIMARY KEY,
  id_edicion INT REFERENCES edicion(id),
  id_venta INT REFERENCES venta(id),
  cantidad INT,
  precio_venta NUMERIC(10,2),
  descuento NUMERIC(5,2)
);

-- Datos de prueba

-- Autores
INSERT INTO autor (nombre, nacionalidad) VALUES
  ('Marco Aurelio', 'Romana'),
  ('Michel de Montaigne', 'Francesa'),
  ('Dante Alighieri', 'Italiana');

-- Editoriales
INSERT INTO editorial (nombre) VALUES
  ('Editorial Clásicos'),
  ('Editorial Humanistas'),
  ('Editorial Renacimiento');

-- Libros
INSERT INTO libro (nombre, idioma_original) VALUES
  ('Meditaciones', 'Latín'),
  ('Ensayos', 'Francés'),
  ('La Odisea', 'Italiano');

-- Relación libro_autor
INSERT INTO libro_autor (id_libro, id_autor, grado) VALUES
  (1, 1, 'Autor'),
  (2, 2, 'Autor'),
  (3, 3, 'Autor');

-- Ediciones
INSERT INTO edicion (idioma, encuadernacion, dimensiones, traductor, fecha_publicacion, precio_venta, resumen, id_libro, id_editorial) VALUES
  ('Español', 'Tapa dura', '21x14cm', 'Juan Pérez', '2020-01-01', 19.99, 'Obra filosófica fundamental.', 1, 1),
  ('Español', 'Rústica', '23x15cm', 'Ana Gómez', '2018-05-10', 24.50, 'Ensayos clásicos del Renacimiento.', 2, 2),
  ('Español', 'Tapa blanda', '20x13cm', 'Luis Torres', '2015-09-15', 17.75, 'La gran epopeya medieval.', 3, 3);

-- Usuario (cliente)
INSERT INTO usuario (nombre, apellido,email, clave,direccion,numero_telefono) VALUES ('Mauricio','Millan Pariona','prueba@gmail.com','123456','Av. Siempre Viva 123','987654321');

-- Venta
INSERT INTO venta (id_usuario, fecha) VALUES (1, '2025-09-07');
select * from usuario;
select * from venta;
-- Detalle de venta (compra los 3 libros)
INSERT INTO detalle_venta (id_edicion, id_venta, cantidad, precio_venta, descuento) VALUES
  (1, 1, 1, 19.99, 0),
  (2, 1, 1, 24.50, 0),
  (3, 1, 1, 17.75, 0);

select * from detalle_venta;


select * from edicion