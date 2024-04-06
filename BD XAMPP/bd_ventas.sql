-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 28-03-2024 a las 07:31:51
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--
CREATE DATABASE bd_ventas;
USE bd_ventas;
CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`, `Estado`) VALUES
(17, '2', 'Juan Guerrero Solis', 'Los Alamos', '1'),
(18, '1', 'Maria Rosas Villanueva', 'Los Laureles 234', '1'),
(19, '3', 'Andres de Santa Cruz', 'Av. La Frontera 347', '1'),
(20, '4', 'Andres Mendoza', 'Chosica, Lurigancho', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(163, 100, 2, 10, 20),
(164, 101, 1, 4, 91),
(165, 101, 3, 1, 800),
(166, 101, 2, 1, 20),
(167, 102, 3, 2, 800),
(168, 103, 3, 2, 800),
(169, 103, 5, 4, 100),
(170, 104, 3, 5, 800),
(171, 104, 5, 2, 100),
(172, 105, 5, 1, 100),
(173, 105, 2, 3, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL,
  `Password` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`, `Password`) VALUES
(1, '123', 'Pedro Hernandez', '988252459', '1', 'emp01', 'YTY2NWE0NTkyMDQyMmY5ZDQxN2U0ODY3ZWZkYzRmYjhhMDRhMWYzZmZmMWZhMDdlOTk4ZTg2ZjdmN2EyN2FlMw=='),
(2, '123', 'Roman Riquelme', '988252459', '1', 'Jo46', 'YjNhOGUwZTFmOWFiMWJmZTNhMzZmMjMxZjY3NmY3OGJiMzBhNTE5ZDJiMjFlNmM1MzBjMGVlZThlYmI0YTVkMA=='),
(3, '123', 'Bob Esponja', '10101011', '1', 'Bob123', 'MzVhOWUzODFiMWEyNzU2NzU0OWI1ZjhhNmY3ODNjMTY3ZWJmODA5ZjFjNGQ2YTllMzY3MjQwNDg0ZDhjZTI4MQ=='),
(11, '123', 'Patricio Estrella', '1245512', '1', 'Pati999', 'ZjZlMGExZTJhYzQxOTQ1YTlhYTdmZjhhOGFhYTBjZWJjMTJhM2JjYzk4MWE5MjlhZDVjZjgxMGEwOTBlMTFhZQ=='),
(17, '123', 'Vicente Fernandez', '4545499', '1', 'VF777', 'ZWFmODlkYjcxMDg0NzBkYzNmNmIyM2VhOTA2MTgyNjRiM2U4ZjhiNjE0NTM3MTY2N2M0MDU1ZTljNWNlOWY1Mg=='),
(18, '123', 'Jhon malio', '1245512', '1', 'JhonxD', 'MmFjOWE2NzQ2YWNhNTQzYWY4ZGZmMzk4OTRjZmU4MTczYWZiYTIxZWIwMWM2ZmFlMzNkNTI5NDcyMjI4NTVlZg=='),
(19, '123', 'Steeven CareMonda', '2101010', '1', 'Call27', 'NTVjODA3OWFjOTZjNmE0ZjZhOTRlMzQ2MGM3OWU0MDA2ZDYyMzc0Y2NlNmU5ZmM4YjI4MTkzOGEzYWJjNzYyNw=='),
(21, '123', 'Alejandro Velez', '5656565', '1', 'VA555', 'OTFhNzNmZDgwNmFiMmMwMDVjMTNiNGRjMTkxMzBhODg0ZTkwOWRlYTNmNzJkNDZlMzAyNjZmZTFhMWY1ODhkOA=='),
(22, '843', 'Juan Pedro', '9402054', '1', 'JU222', 'OWI4NzE1MTIzMjdjMDljZTkxZGQ2NDliM2Y5NmE2M2I3NDA4ZWYyNjdjOGNjNTcxMDExNGU2Mjk3MzBjYjYxZg==');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'Teclado Logitech 345 Editado', 91, 46, '1'),
(2, 'Mouse Logitech 567', 20, 31, '1'),
(3, 'Laptop Lenovo Ideapad 520', 800, 20, '1'),
(4, 'HeadPhones Sony M333', 500, 90, '1'),
(5, 'Producto Nuevo w', 100, 193, '1'),
(10, 'RTX 4060 Ti Gigabyte', 500, 15, '1'),
(14, 'M2 Samsung 4.0 1TB', 80, 45, '1'),
(15, 'Teclado Corsair', 100, 25, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdEmpleado`, `NumeroSerie`, `FechaVentas`, `Monto`, `Estado`) VALUES
(100, 20, 2, '00000001', '2023-10-16', 20, '1'),
(101, 18, 2, '00000002', '2023-10-16', 20, '1'),
(102, 18, 2, '00000003', '2023-10-16', 800, '1'),
(103, 20, 2, '00000003', '2023-10-16', 100, '1'),
(104, 18, 2, '00000004', '2023-10-16', 100, '1'),
(105, 17, 2, '00000005', '2023-10-16', 20, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdEmpleado`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=174;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
