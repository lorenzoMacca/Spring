-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: mytraining
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `mytraining`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mytraining` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mytraining`;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` double NOT NULL,
  `time` time NOT NULL,
  `exercise_type_id` bigint(20) NOT NULL,
  `session_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnw91ts622h271oq286bdtng66` (`exercise_type_id`),
  KEY `FK3ak1exadafy6ur2yy3cowacj0` (`session_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (34,'2018-11-25',NULL,10,'11:00:00',5,33);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_rep`
--

DROP TABLE IF EXISTS `exercise_rep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise_rep` (
  `id` bigint(20) NOT NULL,
  `value` double NOT NULL,
  `exercise_set_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpgkonqc0shrntqe1kcy4utb9t` (`exercise_set_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_rep`
--

LOCK TABLES `exercise_rep` WRITE;
/*!40000 ALTER TABLE `exercise_rep` DISABLE KEYS */;
INSERT INTO `exercise_rep` VALUES (36,60,35),(38,60,37);
/*!40000 ALTER TABLE `exercise_rep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_set`
--

DROP TABLE IF EXISTS `exercise_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise_set` (
  `id` bigint(20) NOT NULL,
  `exercise_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2l9crqua2gdu9b38sfd4954s7` (`exercise_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_set`
--

LOCK TABLES `exercise_set` WRITE;
/*!40000 ALTER TABLE `exercise_set` DISABLE KEYS */;
INSERT INTO `exercise_set` VALUES (35,34),(37,34);
/*!40000 ALTER TABLE `exercise_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_type`
--

DROP TABLE IF EXISTS `exercise_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise_type` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_type`
--

LOCK TABLES `exercise_type` WRITE;
/*!40000 ALTER TABLE `exercise_type` DISABLE KEYS */;
INSERT INTO `exercise_type` VALUES (5,'abs core','Plank');
/*!40000 ALTER TABLE `exercise_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (133),(133),(133),(133),(133),(133),(133),(133),(133),(133);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indoor_swim`
--

DROP TABLE IF EXISTS `indoor_swim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indoor_swim` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` double NOT NULL,
  `movement_duration` double DEFAULT NULL,
  `number_of_laps` int(11) NOT NULL,
  `pool_length` int(11) NOT NULL,
  `time` time NOT NULL,
  `pattern_id` bigint(20) DEFAULT NULL,
  `session_id` bigint(20) NOT NULL,
  `swimming_place_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8r34v2280wlusunmfxcg5pg4x` (`pattern_id`),
  KEY `FKkxv3olc298bphrg3ed5mufk40` (`session_id`),
  KEY `FK8e7cbjdmtgdmdxtjowfvjmmwp` (`swimming_place_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indoor_swim`
--

LOCK TABLES `indoor_swim` WRITE;
/*!40000 ALTER TABLE `indoor_swim` DISABLE KEYS */;
INSERT INTO `indoor_swim` VALUES (18,'2018-11-08','Great feelings in the new pool in Kiel. pattern: 250-150-100',40,NULL,54,0,'19:21:00',6,17,10),(20,'2018-11-11','Great feelings in the new pool in Kiel. 300-200-100-300-200-100-300',35,NULL,26,2,'11:25:00',7,19,12),(22,'2018-11-13',NULL,50,NULL,60,0,'18:00:00',6,21,10),(24,'2018-11-15',NULL,50,NULL,60,0,'18:00:00',6,23,10),(26,'2018-11-16',NULL,40,NULL,48,0,'19:20:00',7,25,13),(28,'2018-11-18',NULL,48,NULL,60,0,'13:30:00',7,27,13),(30,'2018-11-20',NULL,48,NULL,60,0,'18:30:00',8,29,11),(32,'2018-11-23',NULL,45,NULL,60,0,'17:30:00',8,31,11),(40,'2018-11-25',NULL,40,NULL,60,0,'15:00:00',8,39,11),(42,'2018-11-27',NULL,39,NULL,60,0,'19:30:00',9,41,11),(44,'2018-11-30',NULL,42,NULL,62,0,'19:00:00',8,43,11),(46,'2018-12-01',NULL,37,NULL,52,0,'12:00:00',8,45,11),(48,'2018-12-04',NULL,45,NULL,60,0,'18:00:00',8,47,11),(50,'2018-12-06',NULL,43,NULL,64,0,'19:00:00',8,49,10),(52,'2018-12-12',NULL,47,NULL,64,0,'18:45:00',NULL,51,13),(54,'2018-12-13',NULL,46,NULL,64,0,'18:45:00',NULL,53,10),(56,'2018-12-16',NULL,50,NULL,64,0,'10:30:00',NULL,55,11),(58,'2018-12-17',NULL,49,NULL,68,0,'18:30:00',NULL,57,13),(60,'2018-12-20',NULL,38.09,NULL,60,0,'06:30:00',NULL,59,14),(62,'2018-12-23',NULL,42,NULL,48,1,'09:00:00',NULL,61,15),(64,'2018-12-27',NULL,42.29,34.3,60,0,'11:33:00',NULL,63,16),(66,'2018-12-30',NULL,51,38.07,36,2,'13:18:00',NULL,65,12),(68,'2019-01-02',NULL,41.53,31.41,60,0,'17:39:00',NULL,67,13),(70,'2019-01-04',NULL,40.08,34.04,64,0,'10:26:00',NULL,69,13),(72,'2019-01-07',NULL,45.1,35.47,68,0,'18:05:00',NULL,71,13),(74,'2019-01-09',NULL,39.25,32.1,60,0,'18:57:00',NULL,73,13),(78,'2019-01-12',NULL,46.3,34.09,68,0,'12:01:00',NULL,77,11),(80,'2019-01-15',NULL,40.44,32.22,64,0,'17:11:00',NULL,79,11),(84,'2019-01-17',NULL,43.35,35.52,64,0,'17:01:00',NULL,83,10),(86,'2019-01-24',NULL,33.51,26.02,48,0,'18:05:00',NULL,85,10),(88,'2019-01-27',NULL,29.49,24.38,48,0,'11:07:00',NULL,87,11),(90,'2019-01-29',NULL,39.35,31.51,60,0,'18:38:00',NULL,89,10),(92,'2019-01-31',NULL,39.32,30.26,60,0,'17:38:00',NULL,91,10),(94,'2019-02-03',NULL,38.45,34.44,64,0,'10:49:00',NULL,93,11),(96,'2019-02-05',NULL,35.2,29.08,56,0,'18:40:00',NULL,95,10),(98,'2019-02-07',NULL,41.03,31.44,64,0,'17:09:00',NULL,97,10),(100,'2019-02-09',NULL,32.46,26.47,52,0,'08:30:00',NULL,99,10),(102,'2019-02-12',NULL,42.25,35.17,68,0,'18:36:00',NULL,101,11),(106,'2019-02-14',NULL,41.45,36.14,68,0,'18:04:00',NULL,105,10),(110,'2019-02-17',NULL,42.45,36,68,0,'12:04:00',NULL,109,11),(114,'2019-02-19',NULL,40.04,35.01,68,0,'17:43:00',NULL,113,11),(116,'2019-02-21',NULL,42.43,36.05,70,0,'17:09:00',NULL,115,10),(118,'2019-02-23',NULL,40.39,35.39,70,0,'10:45:00',NULL,117,11),(122,'2019-02-26',NULL,42.04,35.42,70,0,'19:34:00',NULL,121,11),(126,'2019-02-28',NULL,41.23,37.02,72,0,'17:57:00',NULL,125,10),(128,'2019-03-02',NULL,42.23,37.3,72,0,'10:15:00',NULL,127,11),(132,'2019-03-03','Good swim training with Dani.',43.17,37.2,72,0,'12:48:00',NULL,131,11);
/*!40000 ALTER TABLE `indoor_swim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `run`
--

DROP TABLE IF EXISTS `run`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `run` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `distance` double NOT NULL,
  `duration` double NOT NULL,
  `time` time NOT NULL,
  `session_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKib23x6clwh09c865tsf2voyru` (`session_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `run`
--

LOCK TABLES `run` WRITE;
/*!40000 ALTER TABLE `run` DISABLE KEYS */;
INSERT INTO `run` VALUES (76,'2019-01-10',NULL,5.01,28.18,'17:49:00',75),(82,'2019-01-16',NULL,6.02,33.36,'16:01:00',81),(104,'2019-02-13',NULL,5.19,28.22,'17:27:00',103),(108,'2019-02-16',NULL,5.3,32.27,'10:46:00',107),(112,'2019-02-18',NULL,6.03,33.15,'16:22:00',111),(120,'2019-02-23',NULL,5.24,35.04,'17:22:00',119),(124,'2019-02-27',NULL,5.01,28.31,'16:32:00',123),(130,'2019-03-02',NULL,6.08,37.27,'12:53:00',129);
/*!40000 ALTER TABLE `run` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (17),(19),(21),(23),(25),(27),(29),(31),(33),(39),(41),(43),(45),(47),(49),(51),(53),(55),(57),(59),(61),(63),(65),(67),(69),(71),(73),(75),(77),(79),(81),(83),(85),(87),(89),(91),(93),(95),(97),(99),(101),(103),(105),(107),(109),(111),(113),(115),(117),(119),(121),(123),(125),(127),(129),(131);
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `swim_training_pattern`
--

DROP TABLE IF EXISTS `swim_training_pattern`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `swim_training_pattern` (
  `id` bigint(20) NOT NULL,
  `pattern` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `swim_training_pattern`
--

LOCK TABLES `swim_training_pattern` WRITE;
/*!40000 ALTER TABLE `swim_training_pattern` DISABLE KEYS */;
INSERT INTO `swim_training_pattern` VALUES (6,'250-150-100'),(7,'300-200-100'),(8,'300-200'),(9,'400-300');
/*!40000 ALTER TABLE `swim_training_pattern` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `swimming_place`
--

DROP TABLE IF EXISTS `swimming_place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `swimming_place` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `webpage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `swimming_place`
--

LOCK TABLES `swimming_place` WRITE;
/*!40000 ALTER TABLE `swimming_place` DISABLE KEYS */;
INSERT INTO `swimming_place` VALUES (10,'Westfalenstraße 201 48165 Münster',7.6379748,51.900642,'Hallenbad Hiltrup',NULL),(11,'Mauritz-Lindenweg 101 48145 Münster',7.5813466,51.9484584,'Hallenbad Ost',NULL),(12,'Anni-Wadle-Weg 1, 24143 Kiel',7.5813466,51.9484584,'Hörnbad',NULL),(13,'Badestr. 8 48149 Münster',7.5813466,51.9484584,'Hallenbad Mitte',NULL),(14,'Badestr. 8 48149 Münster',7.5813466,51.9484584,'Hallenbad Kinderhause',NULL),(15,'Badestr. 8 48149 Münster',7.5813466,51.9484584,'MuellerschesVolksbad',NULL),(16,'Via Repaci, 40, 87036 Roges CS, Italien',7.5813466,51.9484584,'Scorpion',NULL);
/*!40000 ALTER TABLE `swimming_place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `surname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Hi! my Name is Lorenzo and I live in Münster, DE','Lorenzo','','cozza'),(2,'Hi! my Name is Daniela and I live in Münster und I\'m beautiful','Daniela','daniela_gutschmidt.jpg','Gutschmidt'),(3,'Hi! my Name is Jan and I won the Ironman Hawaii two times','Jan','frodo.jpg','Frodeno'),(4,'Hi! my Name is Lange and I won the Ironman Hawaii two times','Patrick','lange.jpg','Lange');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_exercise`
--

DROP TABLE IF EXISTS `user_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_exercise` (
  `user_id` bigint(20) NOT NULL,
  `exercise_id` bigint(20) NOT NULL,
  KEY `FKslmctukk6p3cdwi9mi3xlktos` (`exercise_id`),
  KEY `FKiap7apmvrk8nvjl0vge64k9o0` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_exercise`
--

LOCK TABLES `user_exercise` WRITE;
/*!40000 ALTER TABLE `user_exercise` DISABLE KEYS */;
INSERT INTO `user_exercise` VALUES (34,1);
/*!40000 ALTER TABLE `user_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_run`
--

DROP TABLE IF EXISTS `user_run`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_run` (
  `user_id` bigint(20) NOT NULL,
  `run_id` bigint(20) NOT NULL,
  KEY `FKro14e37evp6m0ryx90gnptms5` (`run_id`),
  KEY `FK10nsage35enboyi8o8uglsvcr` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_run`
--

LOCK TABLES `user_run` WRITE;
/*!40000 ALTER TABLE `user_run` DISABLE KEYS */;
INSERT INTO `user_run` VALUES (76,1),(82,1),(104,1),(108,1),(108,2),(112,1),(120,1),(120,2),(124,1),(130,1);
/*!40000 ALTER TABLE `user_run` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_swim`
--

DROP TABLE IF EXISTS `user_swim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_swim` (
  `user_id` bigint(20) NOT NULL,
  `indoor_swim_id` bigint(20) NOT NULL,
  KEY `FK3cejjtqjhad1vo0g5t0m1vhd8` (`indoor_swim_id`),
  KEY `FKrmjxjmp9q60nk1gaem65f53d0` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_swim`
--

LOCK TABLES `user_swim` WRITE;
/*!40000 ALTER TABLE `user_swim` DISABLE KEYS */;
INSERT INTO `user_swim` VALUES (18,1),(18,2),(20,1),(22,1),(22,2),(24,1),(24,2),(26,1),(28,1),(28,2),(30,1),(30,2),(32,1),(32,2),(40,1),(40,2),(42,1),(42,2),(44,1),(44,2),(46,1),(46,2),(48,1),(48,2),(50,1),(50,2),(52,1),(52,2),(54,1),(54,2),(56,1),(58,1),(58,2),(60,1),(62,1),(62,2),(64,1),(64,2),(66,1),(66,2),(68,1),(68,2),(70,1),(72,1),(74,1),(74,2),(78,1),(78,2),(80,1),(80,2),(84,1),(84,2),(86,1),(86,2),(88,1),(88,2),(90,1),(90,2),(92,1),(92,2),(94,1),(94,2),(96,1),(96,2),(98,1),(98,2),(100,1),(100,2),(102,1),(102,2),(106,1),(106,2),(110,1),(110,2),(114,1),(114,2),(116,1),(116,2),(118,1),(122,1),(122,2),(126,1),(128,1),(132,1),(132,2);
/*!40000 ALTER TABLE `user_swim` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-03 16:27:44
