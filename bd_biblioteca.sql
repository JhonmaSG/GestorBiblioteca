CREATE DATABASE bd_biblioteca_alexandria;
USE bd_biblioteca_alexandria;

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    contraseña VARCHAR(50) NOT NULL,
    respuesta_contra VARCHAR(50) NOT NULL,
    cedula INT NOT NULL,
    correo VARCHAR(50) NOT NULL,
    nombre_usuario VARCHAR(50) NOT NULL,
    estado VARCHAR(50) DEFAULT 'Activo',
    rol VARCHAR(10) DEFAULT 'NOVIP'
);

CREATE TABLE Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    contraseña VARCHAR(50) NOT NULL,
    respuesta_contra VARCHAR(50) NOT NULL,
    cedula INT NOT NULL,
    correo VARCHAR(50) NOT NULL,
    nombre_usuario VARCHAR(30) not null,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE Libro (
	id_libro INT AUTO_INCREMENT PRIMARY KEY NOT NULL, 
	titulo VARCHAR(50) NOT NULL,
	autor VARCHAR(50) NOT NULL,
	genero VARCHAR(50) NOT NULL,
   	publicacion DATE NOT NULL,
  	cantidad_disponible INT NOT NULL
);


CREATE TABLE Prestamo (
	id_prestamo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_libro INT NOT NULL,
    id_usuario INT NOT NULL,
	fecha_inicio DATE NOT NULL,
	fecha_entrega DATE NOT NULL,
     retraso_dias INT,
  	id_empleado_presta INT NOT NULL,
  	id_empleado_recibe INT NOT NULL,
  	FOREIGN KEY (id_libro) REFERENCES Libro (id_libro) on delete cascade on update cascade,
  	FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario) on delete cascade on update cascade,
   	FOREIGN KEY (id_empleado_presta) REFERENCES Empleado (id_empleado) on delete cascade on update cascade
);

-- inserts
INSERT INTO Libro (id_libro, titulo, autor, genero, publicacion, cantidad_disponible) VALUES
(1, 'El código Da Vinci', 'Dan Brown', 'Misterio', '2003-03-18', 10),
(2, 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', '1997-06-26', 15),
(3, 'Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', '1967-05-30', 8),
(4, '1984', 'George Orwell', 'Ciencia ficción', '1949-06-08', 12),
(5, 'Orgullo y prejuicio', 'Jane Austen', 'Romance', '1813-01-28', 7),
(6, 'Matar a un ruiseñor', 'Harper Lee', 'Ficción', '1960-07-11', 9),
(7, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 'Novela', '1605-01-16', 11),
(31, 'El código del dinero', 'Raimon Samsó', 'Finanzas personales', '2012-03-01', 7),
(9, 'Los juegos del hambre', 'Suzanne Collins', 'Ciencia ficción', '2008-09-14', 6),
(10, 'Crimen y castigo', 'Fyodor Dostoevsky', 'Ficción psicológica', '1866-11-06', 10),
(11, 'El señor de los anillos: La comunidad del anillo', 'J.R.R. Tolkien', 'Fantasía', '1954-07-29', 14),
(12, 'El alquimista', 'Paulo Coelho', 'Novela', '1988-01-01', 8),
(13, 'El león, la bruja y el armario', 'C.S. Lewis', 'Fantasía', '1950-10-16', 12),
(14, 'Anna Karenina', 'Leo Tolstoy', 'Ficción', '1877-01-28', 9),
(15, 'Drácula', 'Bram Stoker', 'Horror gótico', '1897-05-26', 11),
(16, 'Crónica de una muerte anunciada', 'Gabriel García Márquez', 'Novela', '1981-01-01', 7),
(17, 'La metamorfosis', 'Franz Kafka', 'Ficción', '1915-10-15', 13),
(18, 'El nombre del viento', 'Patrick Rothfuss', 'Fantasía', '2007-03-27', 8),
(19, 'Rebelión en la granja', 'George Orwell', 'Alegoría', '1945-08-17', 10),
(20, 'El retrato de Dorian Gray', 'Oscar Wilde', 'Ficción gótica', '1890-07-01', 12),
(21, 'El hobbit', 'J.R.R. Tolkien', 'Fantasía', '1937-09-21', 15),
(22, 'Moby-Dick', 'Herman Melville', 'Aventura', '1851-10-18', 9),
(23, 'Sapiens: De animales a dioses', 'Yuval Noah Harari', 'Historia', '2011-04-15', 11),
(24, 'El amor en los tiempos del cólera', 'Gabriel García Márquez', 'Novela', '1985-01-01', 7),
(25, 'La isla del tesoro', 'Robert Louis Stevenson', 'Aventura', '1883-05-23', 13),
(26, 'El guardián entre el centeno', 'J.D. Salinger', 'Ficción', '1951-07-16', 10),
(27, 'La historia interminable', 'Michael Ende', 'Fantasía', '1979-09-01', 8),
(28, 'Los pilares de la Tierra', 'Ken Follett', 'Histórica', '1989-10-02', 12),
(29, 'Los miserables', 'Victor Hugo', 'Novela', '1862-03-03', 9),
(30, 'La sombra del viento', 'Carlos Ruiz Zafón', 'Misterio', '2001-04-01', 11);

INSERT INTO Empleado (id_empleado, nombre, apellido, contraseña, respuesta_contra, cedula, correo, nombre_usuario, rol) VALUES
(1, 'Juan', 'Triste', '123', 'triste', 123123123, 'juantriste@gmail.com','j001', 'Administrador'),
(2, 'Cristian', 'WhitePink', '123', 'white', 456456456, 'cristiangg@gmail.com','graycol',  'Administrador');

INSERT INTO Usuario (id_usuario, nombre, apellido, contraseña, respuesta_contra, cedula, correo, nombre_usuario, estado) VALUES
(1, 'Alfonso', 'Prieto', '123', 'hermanita', 123456789, 'alfonsoprieto@gmail.com','alfonsin69',  'Inactivo'),
(2, 'Michael', 'Jackson', '456', 'degradado', 987654321, 'mjackson@gmail.com','maicoljason',  'Activo'),
(3, 'Jhon', 'Serrano', '789', 'llarvi', 456789123, 'jmserrano@gmail.com','jmserrano',  'Activo'),
(4, 'Elsa', 'Pato', '111', 'xd', 789123456, 'elsapato@gmail.com','elsapato', 'Activo'),
(5, 'Chayanne', 'Elmejor', '222', 'aprovado',321654987, 'chayannelmejor@gmail.com', 'chayanne', 'Activo');

INSERT INTO Prestamo (id_prestamo, id_libro, id_usuario, fecha_inicio, fecha_entrega, retraso_dias, id_empleado_presta, id_empleado_recibe) VALUES
(1, 2, 1, '2024-05-01', '2024-05-15', 0, 1, 2),
(2, 5, 2, '2024-05-02', '2024-05-16', 0, 2, 2),
(3, 9, 3, '2024-05-03', '2024-05-17', 0, 2, 2),
(4, 12, 4, '2024-05-04', '2024-05-18', 0, 1, 1),
(5, 18, 5, '2024-05-05', '2024-05-19', 0, 1, 1);

