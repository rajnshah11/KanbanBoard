-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: trello
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `comment_tbl`
--

DROP TABLE IF EXISTS `comment_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_tbl` (
  `id` int NOT NULL,
  `comment_description` varchar(255) DEFAULT NULL,
  `task_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb50rt965xwlm5ayiqi1ufur8f` (`task_id`),
  KEY `FKdny9fm5uvy5onjrtcnqephy7h` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_tbl`
--

LOCK TABLES `comment_tbl` WRITE;
/*!40000 ALTER TABLE `comment_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_history`
--

DROP TABLE IF EXISTS `state_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_history` (
  `id` bigint NOT NULL,
  `change_id` int DEFAULT NULL,
  `change_id_type` varchar(255) DEFAULT NULL,
  `task_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7bqi6o4sjlovlmgu01u2hmesj` (`task_id`),
  KEY `FK4kisnbd9eqtxqukgo1wree9x` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_history`
--

LOCK TABLES `state_history` WRITE;
/*!40000 ALTER TABLE `state_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_task`
--

DROP TABLE IF EXISTS `state_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_task` (
  `id` bigint NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  `task_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK95vnaqp5gj4dpuowsnuj6u4gp` (`state_id`),
  KEY `FK7yclw1x4mp511oxg0eucruow6` (`task_id`),
  KEY `FKrrgiy622v6vy3fufb10hitp7a` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_task`
--

LOCK TABLES `state_task` WRITE;
/*!40000 ALTER TABLE `state_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_tbl`
--

DROP TABLE IF EXISTS `state_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_tbl` (
  `id` int NOT NULL,
  `state_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_tbl`
--

LOCK TABLES `state_tbl` WRITE;
/*!40000 ALTER TABLE `state_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_tbl`
--

DROP TABLE IF EXISTS `task_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_tbl` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_tbl`
--

LOCK TABLES `task_tbl` WRITE;
/*!40000 ALTER TABLE `task_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_user`
--

DROP TABLE IF EXISTS `task_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_user` (
  `id` int NOT NULL,
  `task_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpyrpwr38t2u7rqqej6kbcq2na` (`task_id`),
  KEY `FKorll8yxal8ejtnxyc3krua7xc` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_user`
--

LOCK TABLES `task_user` WRITE;
/*!40000 ALTER TABLE `task_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl`
--

DROP TABLE IF EXISTS `user_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tbl` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl`
--

LOCK TABLES `user_tbl` WRITE;
/*!40000 ALTER TABLE `user_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-29 21:54:28
