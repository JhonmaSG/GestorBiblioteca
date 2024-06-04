-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 04-06-2024 a las 02:42:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_biblioteca_alexandria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `respuesta_contra` varchar(50) NOT NULL,
  `cedula` int(12) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `nombre_usuario` varchar(30) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `nombre`, `apellido`, `contraseña`, `respuesta_contra`, `cedula`, `correo`, `nombre_usuario`, `rol`) VALUES
(1, 'Juan', 'Triste', '123', 'triste', 123123123, 'juantriste@gmail.com', 'j001', 'Administrador'),
(2, 'Cristian', 'WhitePink', '123', 'white', 456456456, 'cristiangg@gmail.com', 'graycol', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id_libro` int(12) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `publicacion` date NOT NULL,
  `cantidad_disponible` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id_libro`, `titulo`, `autor`, `genero`, `publicacion`, `cantidad_disponible`) VALUES
(1, 'El código Da Vinci', 'Dan Brown', 'Misterio', '2003-03-18', 14),
(2, 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', '1997-06-26', 20),
(3, 'Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', '1967-05-30', 7),
(4, '1984', 'George Orwell', 'Ciencia ficción', '1949-06-08', 12),
(5, 'Orgullo y prejuicio', 'Jane Austen', 'Romance', '1813-01-28', 7),
(6, 'Matar a un ruiseñor', 'Harper Lee', 'Ficción', '1960-07-11', 9),
(7, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 'Novela', '1605-01-16', 11),
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
(20, 'El retrato de Dorian Gray', 'Oscar Wilde', 'Ficción gótica', '1890-07-01', 11),
(21, 'El hobbit', 'J.R.R. Tolkien', 'Fantasía', '1937-09-21', 15),
(22, 'Moby-Dick', 'Herman Melville', 'Aventura', '1851-10-18', 9),
(23, 'Sapiens: De animales a dioses', 'Yuval Noah Harari', 'Historia', '2011-04-15', 11),
(24, 'El amor en los tiempos del cólera', 'Gabriel García Márquez', 'Novela', '1985-01-01', 7),
(25, 'La isla del tesoro', 'Robert Louis Stevenson', 'Aventura', '1883-05-23', 13),
(26, 'El guardián entre el centeno', 'J.D. Salinger', 'Ficción', '1951-07-16', 10),
(27, 'La historia interminable', 'Michael Ende', 'Fantasía', '1979-09-01', 8),
(28, 'Los pilares de la Tierra', 'Ken Follett', 'Histórica', '1989-10-02', 12),
(29, 'Los miserables', 'Victor Hugo', 'Novela', '1862-03-03', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientousuarios`
--

CREATE TABLE `movimientousuarios` (
  `id_movimiento` int(12) NOT NULL,
  `id_prestamo` int(12) NOT NULL,
  `id_libro` int(12) NOT NULL,
  `id_usuario` int(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `cedula` int(12) NOT NULL,
  `titulo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientousuarios`
--

INSERT INTO `movimientousuarios` (`id_movimiento`, `id_prestamo`, `id_libro`, `id_usuario`, `nombre`, `cedula`, `titulo`) VALUES
(2, 9, 10, 4, 'Elsa', 789123456, 'Crimen y castigo'),
(3, 10, 1, 2, 'Michael', 987654321, 'El código Da Vinci'),
(4, 11, 1, 2, 'Michael', 987654321, 'El código Da Vinci'),
(5, 12, 1, 2, 'Michael', 987654321, 'El código Da Vinci');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id_prestamo` int(12) NOT NULL,
  `id_libro` int(12) NOT NULL,
  `id_usuario` int(12) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_limite` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `retraso_dias` int(12) NOT NULL,
  `id_empleado_presta` int(12) NOT NULL,
  `id_empleado_recibe` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id_prestamo`, `id_libro`, `id_usuario`, `fecha_inicio`, `fecha_limite`, `fecha_entrega`, `retraso_dias`, `id_empleado_presta`, `id_empleado_recibe`) VALUES
(1, 10, 2, '2024-05-01', '2024-05-09', '2024-05-20', 0, 1, 2),
(2, 5, 2, '2024-05-02', '0000-00-00', '2024-05-16', 0, 2, 2),
(3, 9, 3, '2024-05-03', '0000-00-00', '2024-05-17', 0, 2, 2),
(4, 12, 4, '2024-05-04', '0000-00-00', '2024-05-18', 0, 1, 1),
(5, 18, 5, '2024-05-05', '2024-05-12', '2024-05-19', 0, 1, 2),
(6, 3, 3, '2024-05-01', '2024-05-10', '2024-05-21', 0, 1, 2),
(9, 10, 4, '2024-05-15', '2024-05-22', '2024-05-22', 0, 1, 2),
(10, 1, 2, '2024-05-15', '2024-05-22', '2024-05-22', 0, 1, 2),
(11, 1, 2, '2024-05-15', '2024-05-22', '2024-05-22', 0, 1, 2),
(12, 1, 2, '2024-05-15', '2024-05-15', '2024-05-22', 0, 1, 2);

--
-- Disparadores `prestamo`
--
DELIMITER $$
CREATE TRIGGER `insert_movimiento` AFTER INSERT ON `prestamo` FOR EACH ROW BEGIN
    DECLARE empleado_nombre VARCHAR(50);
    DECLARE empleado_cedula INT;
    DECLARE libro_titulo VARCHAR(50);
    
    -- Obtener el nombre y cédula del empleado que recibe el préstamo
    SELECT nombre, cedula INTO empleado_nombre, empleado_cedula
    FROM empleado
    WHERE id_empleado = NEW.id_empleado_recibe;
    
    -- Obtener el título del libro
    SELECT titulo INTO libro_titulo
    FROM libro
    WHERE id_libro = NEW.id_libro;
    
    -- Insertar el registro en movimientousuarios
    INSERT INTO movimientousuarios (id_prestamo, id_libro, id_usuario, nombre, cedula, titulo)
    VALUES (NEW.id_prestamo, NEW.id_libro, NEW.id_usuario, empleado_nombre, empleado_cedula, libro_titulo);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `respuesta_contra` varchar(50) NOT NULL,
  `cedula` int(12) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `estado` varchar(50) DEFAULT 'Activo',
  `rol` varchar(10) DEFAULT 'NOVIP'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `contraseña`, `respuesta_contra`, `cedula`, `correo`, `nombre_usuario`, `estado`, `rol`) VALUES
(2, 'Michael', 'Jackson', '456', 'degradado', 987654321, 'mjackson@gmail.com', 'maicoljason', 'Activo', 'NOVIP'),
(3, 'Jhon', 'Serrano', '789', 'llarvi', 456789123, 'jmserrano@gmail.com', 'jmserrano', 'Activo', 'NOVIP'),
(4, 'Elsa', 'Pato', '111', 'xd', 789123456, 'elsapato@gmail.com', 'elsapato', 'Activo', 'NOVIP'),
(5, 'Chayanne', 'Elmejor', '222', 'aprovado', 321654987, 'chayannelmejor@gmail.com', 'chayanne', 'Activo', 'NOVIP'),
(8, 'andres', 'andres', '321', 'andres', 123, 'andres123@gmail.com', 'andres1233', 'Activo', 'NOVIP');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id_libro`);

--
-- Indices de la tabla `movimientousuarios`
--
ALTER TABLE `movimientousuarios`
  ADD PRIMARY KEY (`id_movimiento`),
  ADD KEY `id_prestamo` (`id_prestamo`),
  ADD KEY `id_libro` (`id_libro`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `id_libro` (`id_libro`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_empleado_presta` (`id_empleado_presta`),
  ADD KEY `id_empleado_recibe` (`id_empleado_recibe`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id_libro` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `movimientousuarios`
--
ALTER TABLE `movimientousuarios`
  MODIFY `id_movimiento` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id_prestamo` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimientousuarios`
--
ALTER TABLE `movimientousuarios`
  ADD CONSTRAINT `movimientousuarios_ibfk_1` FOREIGN KEY (`id_prestamo`) REFERENCES `prestamo` (`id_prestamo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientousuarios_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`),
  ADD CONSTRAINT `movimientousuarios_ibfk_3` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `prestamo_ibfk_3` FOREIGN KEY (`id_empleado_presta`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `prestamo_ibfk_4` FOREIGN KEY (`id_empleado_recibe`) REFERENCES `empleado` (`id_empleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
