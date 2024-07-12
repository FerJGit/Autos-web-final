-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-07-2024 a las 08:08:08
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
-- Base de datos: `automoviles`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos`
--

CREATE TABLE `autos` (
  `id` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idModelo` int(11) NOT NULL,
  `version` varchar(50) NOT NULL,
  `chasis` varchar(17) NOT NULL,
  `motor` varchar(17) NOT NULL,
  `anio` smallint(6) NOT NULL,
  `idColor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autos`
--

INSERT INTO `autos` (`id`, `idMarca`, `idModelo`, `version`, `chasis`, `motor`, `anio`, `idColor`) VALUES
(1, 1, 1, 'Highline 1.8', '1YJ93O3VJV457OL2C', '158KJM490HY1294BB', 2018, 1),
(2, 1, 2, 'Comfortline 200 TSI', '07LSVE567M2G994H8', '679KKW5NMD39VCV23', 2015, 2),
(3, 4, 11, '2.0 Turbo', '852GNA963PKW', '5454LOL6321', 2021, 3),
(4, 2, 6, 'Trendline 1.6V', '228844LKJ963FRG', 'BNBN235678DFGH89T', 2015, 5),
(5, 3, 8, 'Full Full', 'JSJS232323FOIAA!4', 'HJHJHJHHJHJ2323', 2015, 4),
(6, 5, 12, 'Sedán 5 Puertas', 'GNGJKAKS34343', 'LLLL3434NMAS55', 2022, 3),
(7, 3, 7, 'Eléctrico', 'JKAJHA80127812', 'QYUQW7127789HDAS', 2022, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colores`
--

CREATE TABLE `colores` (
  `id` int(11) NOT NULL,
  `color` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colores`
--

INSERT INTO `colores` (`id`, `color`) VALUES
(1, 'Negro'),
(2, 'Blanco'),
(3, 'Rojo'),
(4, 'Azul'),
(5, 'Gris');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id`, `nombre`) VALUES
(1, 'VOLKSWAGEN'),
(2, 'RENAULT'),
(3, 'FIAT'),
(4, 'TOYOTA'),
(5, 'FORD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modelos`
--

CREATE TABLE `modelos` (
  `id` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `modelo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `modelos`
--

INSERT INTO `modelos` (`id`, `idMarca`, `modelo`) VALUES
(1, 1, 'Polo'),
(2, 1, 'T-Cross'),
(3, 1, 'Vento'),
(4, 2, 'Sandero'),
(5, 2, 'Duster'),
(6, 2, 'Kangoo'),
(7, 3, 'Cronos'),
(8, 3, 'Pulse'),
(9, 4, 'Etios'),
(10, 4, 'Yaris'),
(11, 4, 'Corolla'),
(12, 5, 'Territory'),
(13, 5, 'Ranger');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autos`
--
ALTER TABLE `autos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idMarca` (`idMarca`),
  ADD KEY `idModelo` (`idModelo`),
  ADD KEY `idColor` (`idColor`);

--
-- Indices de la tabla `colores`
--
ALTER TABLE `colores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `modelos`
--
ALTER TABLE `modelos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGN KEY` (`idMarca`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autos`
--
ALTER TABLE `autos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `colores`
--
ALTER TABLE `colores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `modelos`
--
ALTER TABLE `modelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `autos`
--
ALTER TABLE `autos`
  ADD CONSTRAINT `autos_ibfk_2` FOREIGN KEY (`idModelo`) REFERENCES `modelos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `autos_ibfk_4` FOREIGN KEY (`idColor`) REFERENCES `colores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `autos_ibfk_5` FOREIGN KEY (`idMarca`) REFERENCES `marcas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `modelos`
--
ALTER TABLE `modelos`
  ADD CONSTRAINT `modelos_ibfk_1` FOREIGN KEY (`idMarca`) REFERENCES `marcas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
