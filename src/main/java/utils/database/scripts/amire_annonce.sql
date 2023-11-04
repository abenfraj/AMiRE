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
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annonce` (
  `idAnnonce` int NOT NULL,
  `titre` varchar(256) DEFAULT NULL,
  `niveauxSouhaites` varchar(256) DEFAULT NULL,
  `typeDeContrat` varchar(256) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `idEcole` int DEFAULT NULL,
  `expirationAnnonce` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idAnnonce`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annonce`
--

LOCK TABLES `annonce` WRITE;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
INSERT INTO `annonce` VALUES (1,'Cours avancé de Python','Universitaires','Interim','Cours avancé de Python pour les étudiants universitaires.',1,'2023-12-31'),(2,'Développement Web Full Stack','Universitaires','Salarié','Cours de développement web Full Stack avec HTML, CSS, JavaScript, et Node.js.',2,'2023-11-30'),(3,'Introduction à la Programmation C++','Universitaires','Interim','Cours d\'introduction à la programmation en C++ pour les étudiants.',1,'2024-01-15'),(4,'Développement Mobile avec React Native','Universitaires','Salarié','Cours de développement mobile avec React Native pour les étudiants en informatique.',3,'2023-12-31'),(5,'Cours de Data Science avec Python','Universitaires','Interim','Cours de Data Science avec Python pour les étudiants en sciences des données.',2,'2023-10-20'),(6,'Sécurité Informatique Avancée','Universitaires','Interim','Cours avancé sur la sécurité informatique pour les étudiants en informatique.',4,'2023-11-05'),(7,'Développement d\'Applications Android','Universitaires','Salarié','Cours de développement d\'applications Android pour les étudiants en génie logiciel.',5,'2023-12-31'),(8,'Programmation Java Avancée','Universitaires','Interim','Cours avancé de programmation Java pour les étudiants en informatique.',1,'2023-10-10'),(9,'Conception de Bases de Données','Universitaires','Salarié','Cours de conception de bases de données pour les étudiants en informatique.',3,'2023-12-31'),(10,'Développement Web Front-End','Universitaires','Interim','Cours de développement web Front-End avec HTML, CSS et JavaScript.',2,'2023-12-31'),(11,'Sécurité des Réseaux Informatiques','Universitaires','Interim','Cours sur la sécurité des réseaux informatiques pour les étudiants en informatique.',1,'2023-11-15'),(12,'Introduction à la Programmation Java','Universitaires','Interim','Cours d\'introduction à la programmation Java pour les étudiants.',2,'2023-11-30'),(13,'Développement d\'Applications iOS','Universitaires','Salarié','Cours de développement d\'applications iOS pour les étudiants en génie logiciel.',3,'2023-12-31'),(14,'Analyse de Données avec R','Universitaires','Interim','Cours d\'analyse de données avec R pour les étudiants en statistiques.',4,'2023-10-20'),(15,'Développement Web avec Node.js','Universitaires','Interim','Cours de développement web avec Node.js pour les étudiants en informatique.',2,'2023-11-30'),(16,'Introduction à la Data Science','Universitaires','Salarié','Cours d\'introduction à la Data Science pour les étudiants en sciences des données.',4,'2023-12-31'),(17,'Sécurité des Applications Mobiles','Universitaires','Interim','Cours sur la sécurité des applications mobiles pour les étudiants en génie logiciel.',5,'2023-11-15');
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
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
