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
-- Table structure for table `candidature`
--

DROP TABLE IF EXISTS `candidature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidature` (
  `idCandidature` int NOT NULL,
  `dateCandidature` varchar(45) DEFAULT NULL,
  `contacteParPersonne` varchar(45) DEFAULT NULL,
  `contacteLe` varchar(45) DEFAULT NULL,
  `decision` varchar(45) DEFAULT NULL,
  `idEnseignant` int DEFAULT NULL,
  `idAnnonce` int DEFAULT NULL,
  PRIMARY KEY (`idCandidature`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidature`
--

LOCK TABLES `candidature` WRITE;
/*!40000 ALTER TABLE `candidature` DISABLE KEYS */;
INSERT INTO `candidature` VALUES (1,'2023-01-15','Chef de departement Informatique','2023-01-20','Accepté',1,1),(2,'2023-02-10','Responsable pédagogique','2023-02-15','Refusé',2,2),(3,'2023-03-05','Responsable des admissions','2023-03-10','En attente',3,3),(4,'2023-04-20','Responsable pédagogique','2023-04-25','Accepté',1,1),(5,'2023-05-15','Chef de département Informatique','2023-05-20','Refusé',4,4),(6,'2023-06-30','Responsable des admissions','2023-07-05','Accepté',2,2),(7,'2023-07-10','Chef de département Informatique','2023-07-15','Refusé',5,5),(8,'2023-08-05','Responsable pédagogique','2023-08-10','En attente',3,3),(9,'2023-09-20','Directeur de l\'école','2023-09-25','Accepté',4,4),(10,'2023-10-15','Responsable pédagogique','2023-10-20','Refusé',5,5),(11,'2023-10-30','Responsable des admissions','2023-11-05','En attente',6,6),(12,'2023-11-10','Chef de département Informatique','2023-11-15','Refusé',8,8),(13,'2023-12-05','Responsable pédagogique','2023-12-10','En attente',7,7),(14,'2024-01-15','Responsable des admissions','2024-01-20','Accepté',7,7),(15,'2023-11-10','Chef de département Informatique','2023-11-15','Refusé',9,9),(16,'2023-12-05','Responsable pédagogique','2023-12-10','En attente',10,10),(17,'2024-01-15','Responsable des admissions','2024-01-20','Accepté',9,9);
/*!40000 ALTER TABLE `candidature` ENABLE KEYS */;
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
