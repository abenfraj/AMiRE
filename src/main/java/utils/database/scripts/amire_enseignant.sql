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
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enseignant` (
  `idenseignant` int NOT NULL,
  `nomEnseignant` varchar(256) DEFAULT NULL,
  `prenomEnseignant` varchar(256) DEFAULT NULL,
  `siteWeb` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `telephone` varchar(256) DEFAULT NULL,
  `typeDeContrat` varchar(256) DEFAULT NULL,
  `disponibilites` varchar(256) DEFAULT NULL,
  `competences` varchar(256) DEFAULT NULL,
  `interetEcole` varchar(256) DEFAULT NULL,
  `interetDomaines` varchar(256) DEFAULT NULL,
  `niveauxSouhaites` varchar(256) DEFAULT NULL,
  `experience` varchar(256) DEFAULT NULL,
  `titresAcademiques` varchar(256) DEFAULT NULL,
  `divers` varchar(256) DEFAULT NULL,
  `recommandations` varchar(256) DEFAULT NULL,
  `evaluation` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idenseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enseignant`
--

LOCK TABLES `enseignant` WRITE;
/*!40000 ALTER TABLE `enseignant` DISABLE KEYS */;
INSERT INTO `enseignant` VALUES (1,'Durand','Marie','http://www.mariedurand.com','marie.durand@example.com','123456789','Interim','Disponibilités 1','Python, JavaScript, C++','Informatique','Développement Web','Universitaires','Expérience 1','Titres académiques 1','Divers 1','Recommandations 1','Évaluation 1'),(2,'Lefebvre','Thomas','http://www.thomaslefebvre.com','thomas.lefebvre@example.com','987654321','Salarié','Disponibilités 2','HTML, CSS, JavaScript, Node.js','Informatique','Développement Web','Universitaires','Expérience 2','Titres académiques 2','Divers 2','Recommandations 2','Évaluation 2'),(3,'Martin','Sophie','http://www.sophiemartin.com','sophie.martin@example.com','555555555','Interim','Disponibilités 3','Java, Python, C','Informatique','Programmation','Universitaires','Expérience 3','Titres académiques 3','Divers 3','Recommandations 3','Évaluation 3'),(4,'Dubois','Antoine','http://www.antoinedubois.com','antoine.dubois@example.com','666666666','Salarié','Disponibilités 4','JavaScript, PHP, Ruby','Informatique','Développement Web','Universitaires','Expérience 4','Titres académiques 4','Divers 4','Recommandations 4','Évaluation 4'),(5,'Girard','Luc','http://www.lucgirard.com','luc.girard@example.com','777777777','Salarié','Disponibilités 5','React Native, React, Android','Informatique','Développement Mobile','Universitaires','Expérience 5','Titres académiques 5','Divers 5','Recommandations 5','Évaluation 5'),(6,'Moreau','Julie','http://www.juliemoreau.com','julie.moreau@example.com','888888888','Interim','Disponibilités 6','Data Science, Python, R','Sciences des Données','Data Science','Universitaires','Expérience 6','Titres académiques 6','Divers 6','Recommandations 6','Évaluation 6'),(7,'Roux','Pierre','http://www.pierreroux.com','pierre.roux@example.com','999999999','Interim','Disponibilités 7','C#, .NET, SQL','Informatique','Base de Données','Universitaires','Expérience 7','Titres académiques 7','Divers 7','Recommandations 7','Évaluation 7'),(8,'Leroy','Marcelle','http://www.marcelleleroy.com','marcelle.leroy@example.com','1010101010','Salarié','Disponibilités 8','React, Vue.js, Front-End','Informatique','Développement Web','Universitaires','Expérience 8','Titres académiques 8','Divers 8','Recommandations 8','Évaluation 8'),(9,'Bouchard','Sophie','http://www.sophiebouchard.com','sophie.bouchard@example.com','1212121212','Salarié','Disponibilités 9','Java, C++, SQL','Informatique','Programmation','Universitaires','Expérience 9','Titres académiques 9','Divers 9','Recommandations 9','Évaluation 9'),(10,'Perrin','Paul','http://www.paulperrin.com','paul.perrin@example.com','1313131313','Interim','Disponibilités 10','Python, C#, .NET','Informatique','Développement Web','Universitaires','Expérience 10','Titres académiques 10','Divers 10','Recommandations 10','Évaluation 10'),(11,'Lavoie','Claire','http://www.clairelavoie.com','claire.lavoie@example.com','1414141414','Salarié','Disponibilités 11','Node.js, Web Development, JavaScript','Informatique','Développement Web','Universitaires','Expérience 11','Titres académiques 11','Divers 11','Recommandations 11','Évaluation 11'),(12,'Roy','David','http://www.davidroy.com','david.roy@example.com','1515151515','Interim','Disponibilités 12','Data Science, R, Python','Sciences des Données','Data Science','Universitaires','Expérience 12','Titres académiques 12','Divers 12','Recommandations 12','Évaluation 12');
/*!40000 ALTER TABLE `enseignant` ENABLE KEYS */;
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
