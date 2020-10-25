-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 16-10-2020 a las 21:59:30
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nominaWeb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `nombre` varchar(30) COLLATE utf32_spanish2_ci DEFAULT NULL,
  `dni` varchar(9) COLLATE utf32_spanish2_ci NOT NULL,
  `sexo` char(1) COLLATE utf32_spanish2_ci DEFAULT NULL,
  `categoria` int(11) DEFAULT 1,
  `anyos` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish2_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nombre`, `dni`, `sexo`, `categoria`, `anyos`) VALUES
('Ada Lovelace', '32000031R', 'M', 1, 0),
('James Cosling', '32000032G', 'H', 4, 7);

--
-- Disparadores `empleado`
--
DELIMITER $$
CREATE TRIGGER `calSueldoInsert` AFTER INSERT ON `empleado` FOR EACH ROW INSERT into nomina VALUES(new.dni,50000+20000*(new.categoria-1)+5000*new.anyos)
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `calSueldoUpdate` AFTER UPDATE ON `empleado` FOR EACH ROW UPDATE nomina SET sueldo=50000+20000*(new.categoria-1)+5000*new.anyos WHERE dni=new.dni
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina`
--

CREATE TABLE `nomina` (
  `dni` varchar(9) COLLATE utf32_spanish2_ci NOT NULL,
  `sueldo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_spanish2_ci;

--
-- Volcado de datos para la tabla `nomina`
--

INSERT INTO `nomina` (`dni`, `sueldo`) VALUES
('32000031R', 50000),
('32000032G', 145000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD PRIMARY KEY (`dni`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD CONSTRAINT `nomina_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `empleado` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
