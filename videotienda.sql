-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para videotienda
CREATE DATABASE IF NOT EXISTS `videotienda` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `videotienda`;

-- Volcando estructura para tabla videotienda.pelicula
CREATE TABLE IF NOT EXISTS `pelicula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `genero` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `año` int(11) NOT NULL,
  `disponible` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27098 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla videotienda.pelicula: ~56 rows (aproximadamente)
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
REPLACE INTO `peliculas` (`id`, `titulo`, `genero`, `año`, `disponible`) VALUES
	(27034, 'Soy leyenda', 'Ciencia ficción', 2007, b'1'),
	(27035, 'Capitán América: Civil War', 'Acción, Ciencia ficción', 2017, b'0'),
	(27036, 'Pixels', 'Ciencia ficción', 2015, b'1'),
	(27037, 'La guerra de los mundos', 'Ciencia ficción', 2005, b'1'),
	(27038, 'WALL-E', 'Animación', 2006, b'1'),
	(27039, 'La maldición', 'Terror', 2005, b'1'),
	(27040, '300: El origen de un imperio', 'Acción', 2014, b'1'),
	(27041, 'El origen de los guardianes', 'Animación', 2012, b'0'),
	(27042, 'Angry Birds. La película', 'Animación', 2016, b'1'),
	(27043, '007 al servicio de su majestad', 'Acción', 1969, b'1'),
	(27044, 'Species II', 'Ciencia ficción', 2018, b'1'),
	(27045, 'Ex Machina', 'Ciencia ficción', 2015, b'1'),
	(27046, 'Arma Letal', 'Acción', 1987, b'1'),
	(27047, '30 días de oscuridad', 'Terror', 2007, b'1'),
	(27048, 'Arma letal 3', 'Acción', 1991, b'1'),
	(27049, 'Mamá', 'Terror', 2013, b'1'),
	(27050, 'X-Files: Creer es la clave', 'Ciencia ficción', 2008, b'1'),
	(27051, 'Virus', 'Terror', 1999, b'1'),
	(27052, '13 fantasmas', 'Terror', 2001, b'1'),
	(27053, 'Depredador', 'Acción', 1987, b'1'),
	(27054, 'Abraham Lincoln: Cazador de vampiros', 'Acción', 2012, b'1'),
	(27055, 'The Phantom of the Opera', 'Musical', 2004, b'1'),
	(27056, '3 días para matar', 'Acción', 2014, b'1'),
	(27057, 'Viernes 13', 'Ciencia ficción, Terror', 1980, b'1'),
	(27058, 'Dinosaurio', 'Animación', 2006, b'1'),
	(27059, 'Abejas asesinas ', 'Acción', 2002, b'1'),
	(27060, 'Star Wars. Episodio III: La venganza de los Sith', 'Ciencia ficción', 2005, b'1'),
	(27061, 'Vecinos invasores', 'Animación', 2006, b'1'),
	(27062, 'Commando', 'Acción', 1985, b'1'),
	(27063, 'Star Wars: Episodio II, el ataque de los clones', 'Ciencia ficción', 2002, b'1'),
	(27064, 'Actividad paranormal', 'Terror', 2009, b'1'),
	(27065, '4 Fantásticos', 'Acción', 2015, b'1'),
	(27066, 'Anastasia', 'Animación', 1997, b'1'),
	(27067, 'La máquina del tiempo', 'Ciencia ficción', 2001, b'1'),
	(27068, 'Pink Floyd, el muro', 'Musical', 1982, b'1'),
	(27069, 'Perdidos en el espacio', 'Ciencia ficción', 1997, b'1'),
	(27070, 'A flor de piel', 'Acción', 1997, b'1'),
	(27071, 'Tron: Legacy', 'Ciencia ficción', 2010, b'1'),
	(27072, 'La quinta ola', 'Ciencia ficción', 2016, b'1'),
	(27073, 'Arma Letal 2', 'Acción', 1989, b'1'),
	(27074, 'Yo, Robot', 'Ciencia ficción', 2004, b'1'),
	(27075, 'Vampiros de John Carpenter', 'Terror', 1998, b'1'),
	(27076, 'Los Simpson. La película', 'Animación', 2007, b'1'),
	(27077, 'El retorno de los malditos', 'Terror', 2007, b'1'),
	(27078, 'Ouija: El origen del mal', 'Terror', 2016, b'1'),
	(27079, 'Flamenco, flamenco', 'Musical', 2000, b'1'),
	(27080, 'WALL-E', 'Animación', 2006, b'0'),
	(27081, 'Anaconda', 'Acción', 1997, b'1'),
	(27082, 'El libro de la selva 2', 'Animación', 2003, b'1'),
	(27083, 'Alerta máxima', 'Acción', 1992, b'1'),
	(27084, 'Species II', 'Ciencia ficción', 1998, b'1'),
	(27085, 'Viernes 13', 'Terror', 2009, b'1'),
	(27093, 'Aeon Flux', 'Acción', 2005, b'1'),
	(27094, 'Los pilares de la tierra', 'Ciencia ficción, Terror', 2000, b'1'),
	(27096, 'El último samurai', 'Acción, Drama', 2010, b'1'),
	(27097, 'Cuentos de los hermanos Grimm', 'Animación', 1960, b'1');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
