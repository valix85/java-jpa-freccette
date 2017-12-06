-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              5.7.20-log - MySQL Community Server (GPL)
-- S.O. server:                  Win64
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database freccette
CREATE DATABASE IF NOT EXISTS `freccette` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `freccette`;

-- Dump della struttura di tabella freccette.partita
CREATE TABLE IF NOT EXISTS `partita` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_partita` datetime DEFAULT NULL,
  `punteggio` int(150) DEFAULT NULL,
  `id_persona` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_persona` (`id_persona`),
  CONSTRAINT `partita_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella freccette.partita: ~2 rows (circa)
/*!40000 ALTER TABLE `partita` DISABLE KEYS */;
INSERT INTO `partita` (`id`, `data_partita`, `punteggio`, `id_persona`) VALUES
	(1, '2017-01-01 10:34:30', 140, 4),
	(4, '2017-11-21 10:36:15', 95, 3);
/*!40000 ALTER TABLE `partita` ENABLE KEYS */;

-- Dump della struttura di tabella freccette.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) DEFAULT NULL,
  `cognome` varchar(40) DEFAULT NULL,
  `nickname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella freccette.persona: ~4 rows (circa)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id`, `nome`, `cognome`, `nickname`) VALUES
	(1, 'Gennaro', 'Lo Storto', 'Fuoco82'),
	(2, 'Vanessa', 'Bomber', 'Bomba90'),
	(3, 'Marco', 'Cieco', 'Cecchino88'),
	(4, 'Simona', 'Abbondanza', 'Primizia48');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
