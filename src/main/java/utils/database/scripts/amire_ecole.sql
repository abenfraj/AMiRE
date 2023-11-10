CREATE DATABASE  IF NOT EXISTS `amire` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `amire`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: amire
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ecole` (
  `idEcole` int NOT NULL,
  `raisonSociale` varchar(256) DEFAULT NULL,
  `competences` varchar(4256) DEFAULT NULL,
  `besoins` varchar(256) DEFAULT NULL,
  `exigences` varchar(256) DEFAULT NULL,
  `periode` varchar(256) DEFAULT NULL,
  `remarques` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idEcole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE `amire`.`ecole`
    CHANGE COLUMN `idEcole` `idEcole` INT NOT NULL AUTO_INCREMENT ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ecole`
--

LOCK TABLES `ecole` WRITE;
/*!40000 ALTER TABLE `ecole` DISABLE KEYS */;
INSERT INTO `ecole` VALUES (1,'Université Tech','Développement informatique','Enseignants qualifiés','Inscription en cours','2023-2024','Remarques sur l\'école'),(2,'École de Développeurs','Formation en développement informatique','Formateurs expérimentés','Inscriptions ouvertes','2023-2024','Remarques sur l\'école de développeurs'),(3,'École de Sciences Informatiques','Sciences informatiques avancées','Professeurs hautement qualifiés','Inscriptions en cours','2023-2024','Remarques sur l\'école de sciences informatiques'),(4,'Institut des Technologies Numériques','Technologies numériques avancées','Formateurs expérimentés','Inscriptions ouvertes','2023-2024','Remarques sur l\'institut des technologies numériques'),(5,'École d\'Informatique Appliquée','Informatique appliquée avancée','Enseignants experts','Inscriptions en cours','2023-2024','Remarques sur l\'école d\'informatique appliquée'),(6,'Institut des Sciences des Données','Sciences des données avancées','Professeurs de renom','Inscriptions ouvertes','2023-2024','Remarques sur l\'institut des sciences des données'),(7,'École d\'Informatique Avancée','Informatique avancée','Professeurs experts','Inscriptions ouvertes','2023-2024','Remarques sur l\'école d\'informatique avancée'),(8,'Institut des Sciences Informatiques Appliquées','Sciences informatiques appliquées','Formateurs qualifiés','Inscriptions en cours','2023-2024','Remarques sur l\'institut des sciences informatiques appliquées'),(9,'École d\'Informatique Appliquée','Informatique appliquée avancée','Formateurs qualifiés','Inscriptions ouvertes','2023-2024','Remarques sur l\'école d\'informatique appliquée'),(10,'Institut des Sciences Informatiques Avancées','Sciences informatiques avancées','Enseignants experts','Inscriptions en cours','2023-2024','Remarques sur l\'institut des sciences informatiques avancées'),(11,'École d\'Informatique Avancée','Informatique avancée','Formateurs qualifiés','Inscriptions ouvertes','2023-2024','Remarques sur l\'école d\'informatique avancée'),(12,'Institut des Sciences Informatiques Avancées','Sciences informatiques avancées','Enseignants experts','Inscriptions en cours','2023-2024','Remarques sur l\'institut des sciences informatiques avancées');
/*!40000 ALTER TABLE `ecole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-31 16:34:24
