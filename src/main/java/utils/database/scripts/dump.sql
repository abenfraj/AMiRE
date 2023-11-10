mysqldump: [Warning] Using a password on the command line interface can be insecure.
-- MySQL dump 10.13  Distrib 8.1.0, for Linux (x86_64)
--
-- Host: localhost    Database: amire
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `password` varchar(90) DEFAULT NULL,
  `idEcole` int DEFAULT NULL,
  `idEnseignant` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_ecole_idEcole_fk` (`idEcole`),
  KEY `account_enseignant_idenseignant_fk` (`idEnseignant`),
  CONSTRAINT `account_ecole_idEcole_fk` FOREIGN KEY (`idEcole`) REFERENCES `ecole` (`idEcole`),
  CONSTRAINT `account_enseignant_idenseignant_fk` FOREIGN KEY (`idEnseignant`) REFERENCES `enseignant` (`idenseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'demo','demo',NULL,1),(2,'efrei','je paie les frais',1,NULL),(3,'admin','admin',NULL,NULL),(4,'epita','demo',2,NULL),(5,'IutParis','demo',3,NULL),(6,'toto.mobile','demo',NULL,2),(7,'jean.naymar','demo',NULL,3),(8,'alex.terieur','demo',NULL,4),(9,'alain.terieur','demo',NULL,5),(10,'hannah.tomie','demo',NULL,6),(11,'justin.bridou','demo',NULL,7),(12,'jean.soma','demo',NULL,8);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `annonce` VALUES (1,'Cours avancé de Python','Universitaires','CDD, CDI','Cours avancé de Python pour les étudiants universitaires.',1,'2023-12-31'),(2,'Développement Web Full Stack','Universitaires','CDD, Intérim','Cours de développement web Full Stack avec HTML, CSS, JavaScript, et Node.js.',2,'2023-11-30'),(3,'Introduction à la Programmation C++','Universitaires','Intérim','Cours d\'introduction à la programmation en C++ pour les étudiants.',1,'2024-01-15'),(4,'Développement Mobile avec React Native','Universitaires','CDD','Cours de développement mobile avec React Native pour les étudiants en informatique.',3,'2023-12-31'),(5,'Cours de Data Science avec Python','Universitaires','CDD, CDI','Cours de Data Science avec Python pour les étudiants en sciences des données.',2,'2023-10-20'),(6,'Sécurité Informatique Avancée','Universitaires','CDD, Intérim','Cours avancé sur la sécurité informatique pour les étudiants en informatique.',1,'2023-11-05'),(7,'Développement d\'Applications Android','Universitaires','Intérim','Cours de développement d\'applications Android pour les étudiants en génie logiciel.',3,'2023-12-31'),(8,'Programmation Java Avancée','Universitaires','CDD, CDI','Cours avancé de programmation Java pour les étudiants en informatique.',1,'2023-10-10'),(9,'Conception de Bases de Données','Universitaires','CDD, Intérim','Cours de conception de bases de données pour les étudiants en informatique.',3,'2023-12-31'),(10,'Développement Web Front-End','Universitaires','Intérim','Cours de développement web Front-End avec HTML, CSS et JavaScript.',2,'2023-12-31'),(11,'Sécurité des Réseaux Informatiques','Universitaires','CDD','Cours sur la sécurité des réseaux informatiques pour les étudiants en informatique.',1,'2023-11-15'),(12,'Introduction à la Programmation Java','Universitaires','CDD, CDI','Cours d\'introduction à la programmation Java pour les étudiants.',2,'2023-11-30');
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `candidature` VALUES (1,'2023-01-15','Chef de departement Informatique','2023-01-20','Attente',1,2),(2,'2023-02-10','Responsable pédagogique','2023-02-15','Attente',2,1),(3,'2023-03-05','Responsable des admissions','2023-03-10','Attente',3,2),(4,'2023-04-20','Responsable pédagogique','2023-04-25','Accepté',1,1),(5,'2023-05-15','Chef de département Informatique','2023-05-20','Refusé',4,5),(6,'2023-06-30','Responsable des admissions','2023-07-05','Accepté',2,3),(7,'2023-07-10','Chef de département Informatique','2023-07-15','Refusé',5,5),(8,'2023-08-05','fff','10 novembre 2023','AcceptÃ©e',3,3),(9,'2023-09-20','Directeur de l\'école','2023-09-25','Accepté',4,4),(10,'2023-10-15','Responsable pédagogique','2023-10-20','Refusé',5,6),(11,'2023-10-30','Responsable des admissions','2023-11-05','Attente',6,6),(12,'2023-11-10','Chef de département Informatique','2023-11-15','Refusé',8,8),(13,'2023-12-05','Responsable pédagogique','2023-12-10','Attente',7,7),(14,'2024-01-15','Responsable des admissions','2024-01-20','Accepté',7,8),(15,'2023-11-10','Chef de département Informatique','2023-11-15','Refusé',9,10),(16,'2023-12-05','Responsable pédagogique','2023-12-10','Attente',10,12),(17,'2024-01-15','Responsable des admissions','2024-01-20','Accepté',9,11);
/*!40000 ALTER TABLE `candidature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ecole` (
  `idEcole` int NOT NULL AUTO_INCREMENT,
  `raisonSociale` varchar(256) DEFAULT NULL,
  `competences` varchar(4256) DEFAULT NULL,
  `besoins` varchar(256) DEFAULT NULL,
  `exigences` varchar(256) DEFAULT NULL,
  `periode` varchar(256) DEFAULT NULL,
  `remarques` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idEcole`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ecole`
--

LOCK TABLES `ecole` WRITE;
/*!40000 ALTER TABLE `ecole` DISABLE KEYS */;
INSERT INTO `ecole` VALUES (1,'Efrei','Développement informatique','Enseignants qualifiés','Inscription en cours','2023-2024','Remarques sur l\'école'),(2,'Epita','Formation en développement informatique','Formateurs expérimentés','Inscriptions ouvertes','2023-2024','Remarques sur l\'école de développeurs'),(3,'IUT de Paris','Sciences informatiques avancées','Professeurs hautement qualifiés','Inscriptions en cours','2023-2024','Remarques sur l\'école de sciences informatiques');
/*!40000 ALTER TABLE `ecole` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `enseignant` VALUES (1,'a','Marie','https://zs.d','s@a.d','1234x56789','Interim','fldjfkdjfml','Python, JavaScript, C++','Informatique','a','Universitaires','a','a','Divers 1','Recommandations 1','a'),(2,'Lefebvre','Thomas','http://www.thomaslefebvre.com','thomas.lefebvre@example.com','987654321','Salarié','Disponibilités 2','HTML, CSS, JavaScript, Node.js','Informatique','Développement Web','Universitaires','Expérience 2','Titres académiques 2','Divers 2','Recommandations 2','Évaluation 2'),(3,'Martin','Sophie','http://www.sophiemartin.com','sophie.martin@example.com','555555555','Interim','Disponibilités 3','Java, Python, C','Informatique','Programmation','Universitaires','Expérience 3','Titres académiques 3','Divers 3','Recommandations 3','Évaluation 3'),(4,'Dubois','Antoine','http://www.antoinedubois.com','antoine.dubois@example.com','666666666','Salarié','Disponibilités 4','JavaScript, PHP, Ruby','Informatique','Développement Web','Universitaires','Expérience 4','Titres académiques 4','Divers 4','Recommandations 4','Évaluation 4'),(5,'Girard','Luc','http://www.lucgirard.com','luc.girard@example.com','777777777','Salarié','Disponibilités 5','React Native, React, Android','Informatique','Développement Mobile','Universitaires','Expérience 5','Titres académiques 5','Divers 5','Recommandations 5','Évaluation 5'),(6,'Moreau','Julie','http://www.juliemoreau.com','julie.moreau@example.com','888888888','Interim','Disponibilités 6','Data Science, Python, R','Sciences des Données','Data Science','Universitaires','Expérience 6','Titres académiques 6','Divers 6','Recommandations 6','Évaluation 6'),(7,'Roux','Pierre','http://www.pierreroux.com','pierre.roux@example.com','999999999','Interim','Disponibilités 7','C#, .NET, SQL','Informatique','Base de Données','Universitaires','Expérience 7','Titres académiques 7','Divers 7','Recommandations 7','Évaluation 7'),(8,'Leroy','Marcelle','http://www.marcelleleroy.com','marcelle.leroy@example.com','1010101010','Salarié','Disponibilités 8','React, Vue.js, Front-End','Informatique','Développement Web','Universitaires','Expérience 8','Titres académiques 8','Divers 8','Recommandations 8','Évaluation 8');
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

-- Dump completed on 2023-11-10 22:19:06
