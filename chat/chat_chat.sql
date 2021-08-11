-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: chat
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `sid` varchar(30) DEFAULT NULL,
  `rid` varchar(30) DEFAULT NULL,
  `message` varchar(10000) DEFAULT NULL,
  `seen` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES ('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> hi',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> hello',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test 1',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> test 2',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test 3',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test 4',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test 5',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test 6',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test 7',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> test',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> test1',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> test2',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> test3',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> hi',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> hello ',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> hi',1),('priyanshuarya22','divyanshuarya14 ','Priyanshu>>> hi',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> hello',1),('divyanshuarya14 ','priyanshuarya22','Divyanshu >>> hi',1),('priyanshuarya22','abc123','Priyanshu>>> Hello',1),('abc123','priyanshuarya22','ABC>>> Hi',1);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-11 16:20:59
