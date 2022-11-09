-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: motel_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `path_id_card` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `gender_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdmskax7cwhm0o8jvmntg5s8tq` (`gender_id`),
  CONSTRAINT `FKdmskax7cwhm0o8jvmntg5s8tq` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (4,'2022-11-09 23:46:48.792000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.792000','Mai Ngọc Tùng Sơn','Hà Nội','1999-10-25 00:00:00.000000','sonmnt@gmail.com','Mai Ngọc Tùng Sơn','12345678','$2a$10$7KXIue/E/DoGT8oohBm2o.1lq1L1CgIjj33SxdS/0o3jJu6.aj93e','','0981721306',2);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_transaction_detail`
--

DROP TABLE IF EXISTS `account_transaction_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_transaction_detail` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `info_type_pay` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK66qg6eu6uilqmdwkygm6i8kae` (`account_id`),
  KEY `FKqqm5kyybqctfck4ee9pvo3mbe` (`transaction_id`),
  CONSTRAINT `FK66qg6eu6uilqmdwkygm6i8kae` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKqqm5kyybqctfck4ee9pvo3mbe` FOREIGN KEY (`transaction_id`) REFERENCES `motel_transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_transaction_detail`
--

LOCK TABLES `account_transaction_detail` WRITE;
/*!40000 ALTER TABLE `account_transaction_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenities`
--

DROP TABLE IF EXISTS `amenities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenities` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `flag_custom_seller` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenities`
--

LOCK TABLES `amenities` WRITE;
/*!40000 ALTER TABLE `amenities` DISABLE KEYS */;
INSERT INTO `amenities` VALUES (14,'2022-11-09 23:46:48.960000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.960000','Mai Ngọc Tùng Sơn',_binary '\0','WIFI',NULL);
/*!40000 ALTER TABLE `amenities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (2,'2022-11-09 23:46:48.776000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.776000','Mai Ngọc Tùng Sơn','male'),(3,'2022-11-09 23:46:48.792000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.792000','Mai Ngọc Tùng Sơn','famale');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (18);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `motel` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbgo4e4yb8pbgend6s5pynumfa` (`motel`),
  CONSTRAINT `FKbgo4e4yb8pbgend6s5pynumfa` FOREIGN KEY (`motel`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (16,NULL,NULL,NULL,NULL,NULL,NULL,'dbef0891b20d41d19c7a56563046e594.jpg',NULL);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (5,'2022-11-09 23:46:48.897000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.897000','Mai Ngọc Tùng Sơn',NULL,'Hà Nội'),(6,'2022-11-09 23:46:48.905000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.905000','Mai Ngọc Tùng Sơn',NULL,'Hồ Chí Mình'),(7,'2022-11-09 23:46:48.913000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.913000','Mai Ngọc Tùng Sơn',NULL,'Đà Nẵng'),(8,'2022-11-09 23:46:48.913000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.913000','Mai Ngọc Tùng Sơn',NULL,'Thanh Hóa'),(9,'2022-11-09 23:46:48.928000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.928000','Mai Ngọc Tùng Sơn',NULL,'Thái Bình');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel`
--

DROP TABLE IF EXISTS `motel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `area` float NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `count` int NOT NULL,
  `count_bedroom` int NOT NULL,
  `countwc` int NOT NULL,
  `max_people` int NOT NULL,
  `price` varchar(255) DEFAULT NULL,
  `short_content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `location_id` bigint DEFAULT NULL,
  `pay_info_id` bigint DEFAULT NULL,
  `project_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgmjtduae0w60ypyxu1rlqb1wr` (`account_id`),
  KEY `FKchlqrthc3j207ia3gfy6bk31y` (`location_id`),
  KEY `FKlpvrqileprfhtne606scyg6vk` (`pay_info_id`),
  KEY `FK8pahx2osfph7iyd7a3en137bi` (`project_id`),
  CONSTRAINT `FK8pahx2osfph7iyd7a3en137bi` FOREIGN KEY (`project_id`) REFERENCES `project_motel` (`id`),
  CONSTRAINT `FKchlqrthc3j207ia3gfy6bk31y` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FKgmjtduae0w60ypyxu1rlqb1wr` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKlpvrqileprfhtne606scyg6vk` FOREIGN KEY (`pay_info_id`) REFERENCES `motel_pay_info_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel`
--

LOCK TABLES `motel` WRITE;
/*!40000 ALTER TABLE `motel` DISABLE KEYS */;
INSERT INTO `motel` VALUES (17,'2022-11-09 23:48:23.984000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:48:23.984000','Mai Ngọc Tùng Sơn',25,'nhà trọ này bao gồm rất nhiều tiện ích hay ho rông rãi thoài mái ',2,1,1,2,'2500000','giá rẻ nhanh tay lên bạn ơi','nhà trọ giá rẻ khu Chùa Láng Hà Nội',4,NULL,NULL,15);
/*!40000 ALTER TABLE `motel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_amenities_detail`
--

DROP TABLE IF EXISTS `motel_amenities_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_amenities_detail` (
  `motel_id` bigint NOT NULL,
  `amenties` bigint NOT NULL,
  PRIMARY KEY (`motel_id`,`amenties`),
  KEY `FKnuy6c4cntrie252mjks70ef4e` (`amenties`),
  CONSTRAINT `FK7vful2hx6i49ewnduermtwydp` FOREIGN KEY (`motel_id`) REFERENCES `motel` (`id`),
  CONSTRAINT `FKnuy6c4cntrie252mjks70ef4e` FOREIGN KEY (`amenties`) REFERENCES `amenities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_amenities_detail`
--

LOCK TABLES `motel_amenities_detail` WRITE;
/*!40000 ALTER TABLE `motel_amenities_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel_amenities_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_limit_gender`
--

DROP TABLE IF EXISTS `motel_limit_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_limit_gender` (
  `motel_id` bigint NOT NULL,
  `gender_id` bigint NOT NULL,
  PRIMARY KEY (`motel_id`,`gender_id`),
  KEY `FK7q0gr8xa9ua1pocg9jo8iduf3` (`gender_id`),
  CONSTRAINT `FK7q0gr8xa9ua1pocg9jo8iduf3` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `FKb28imgjbb3slwtlqrxts9ggu3` FOREIGN KEY (`motel_id`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_limit_gender`
--

LOCK TABLES `motel_limit_gender` WRITE;
/*!40000 ALTER TABLE `motel_limit_gender` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel_limit_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_motel_transactions`
--

DROP TABLE IF EXISTS `motel_motel_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_motel_transactions` (
  `motel_id` bigint NOT NULL,
  `motel_transactions_id` bigint NOT NULL,
  PRIMARY KEY (`motel_id`,`motel_transactions_id`),
  UNIQUE KEY `UK_pfh3xd81cnwosk69ect2i70jq` (`motel_transactions_id`),
  CONSTRAINT `FK84ko6dmluwgxf11xpn5xlv9uj` FOREIGN KEY (`motel_transactions_id`) REFERENCES `motel_transaction` (`id`),
  CONSTRAINT `FKn47nb7qa4patakbqg2dyibxjs` FOREIGN KEY (`motel_id`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_motel_transactions`
--

LOCK TABLES `motel_motel_transactions` WRITE;
/*!40000 ALTER TABLE `motel_motel_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel_motel_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_pay_info_detail`
--

DROP TABLE IF EXISTS `motel_pay_info_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_pay_info_detail` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `deposits` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `time_pay_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqbf7j6pm37ndlpnipa1jaqgdr` (`time_pay_id`),
  CONSTRAINT `FKqbf7j6pm37ndlpnipa1jaqgdr` FOREIGN KEY (`time_pay_id`) REFERENCES `time_pay` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_pay_info_detail`
--

LOCK TABLES `motel_pay_info_detail` WRITE;
/*!40000 ALTER TABLE `motel_pay_info_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel_pay_info_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_transaction`
--

DROP TABLE IF EXISTS `motel_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_transaction` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `flag_done` bit(1) NOT NULL,
  `motel_count` int NOT NULL,
  `total_price` varchar(255) DEFAULT NULL,
  `type_pay` varchar(255) DEFAULT NULL,
  `motel_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5i70d9pug1qs3fcah21l04nsw` (`motel_id`),
  CONSTRAINT `FK5i70d9pug1qs3fcah21l04nsw` FOREIGN KEY (`motel_id`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_transaction`
--

LOCK TABLES `motel_transaction` WRITE;
/*!40000 ALTER TABLE `motel_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_transaction_account_transaction_detail_set`
--

DROP TABLE IF EXISTS `motel_transaction_account_transaction_detail_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_transaction_account_transaction_detail_set` (
  `motel_transaction_id` bigint NOT NULL,
  `account_transaction_detail_set_id` bigint NOT NULL,
  PRIMARY KEY (`motel_transaction_id`,`account_transaction_detail_set_id`),
  UNIQUE KEY `UK_7c7knskdbsrflhnrmlu25x45y` (`account_transaction_detail_set_id`),
  CONSTRAINT `FK5gne395t14506d83aaff55h0x` FOREIGN KEY (`account_transaction_detail_set_id`) REFERENCES `account_transaction_detail` (`id`),
  CONSTRAINT `FK623wfkihiqpm4xldkamgwxfum` FOREIGN KEY (`motel_transaction_id`) REFERENCES `motel_transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_transaction_account_transaction_detail_set`
--

LOCK TABLES `motel_transaction_account_transaction_detail_set` WRITE;
/*!40000 ALTER TABLE `motel_transaction_account_transaction_detail_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel_transaction_account_transaction_detail_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_type`
--

DROP TABLE IF EXISTS `motel_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_type` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_type`
--

LOCK TABLES `motel_type` WRITE;
/*!40000 ALTER TABLE `motel_type` DISABLE KEYS */;
INSERT INTO `motel_type` VALUES (10,'2022-11-09 23:46:48.928000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.928000','Mai Ngọc Tùng Sơn','chung cư'),(11,'2022-11-09 23:46:48.944000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.944000','Mai Ngọc Tùng Sơn','chung cư mini'),(12,'2022-11-09 23:46:48.944000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.944000','Mai Ngọc Tùng Sơn','nhà trọ tập thể'),(13,'2022-11-09 23:46:48.960000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.960000','Mai Ngọc Tùng Sơn','homestay');
/*!40000 ALTER TABLE `motel_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel_type_detail`
--

DROP TABLE IF EXISTS `motel_type_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel_type_detail` (
  `motel_id` bigint NOT NULL,
  `type_id` bigint NOT NULL,
  PRIMARY KEY (`motel_id`,`type_id`),
  KEY `FKikov63j2kuolmlixcubak99tq` (`type_id`),
  CONSTRAINT `FKgjulejivscqce82wqb4ftugds` FOREIGN KEY (`motel_id`) REFERENCES `motel` (`id`),
  CONSTRAINT `FKikov63j2kuolmlixcubak99tq` FOREIGN KEY (`type_id`) REFERENCES `motel_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel_type_detail`
--

LOCK TABLES `motel_type_detail` WRITE;
/*!40000 ALTER TABLE `motel_type_detail` DISABLE KEYS */;
INSERT INTO `motel_type_detail` VALUES (17,11),(17,12);
/*!40000 ALTER TABLE `motel_type_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_motel`
--

DROP TABLE IF EXISTS `project_motel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_motel` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_motel`
--

LOCK TABLES `project_motel` WRITE;
/*!40000 ALTER TABLE `project_motel` DISABLE KEYS */;
INSERT INTO `project_motel` VALUES (15,'2022-11-09 23:46:48.994000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.994000','Mai Ngọc Tùng Sơn',NULL,'nhà ở xa hội');
/*!40000 ALTER TABLE `project_motel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'2022-11-09 23:46:48.713000','Mai Ngọc Tùng Sơn',_binary '\0','2022-11-09 23:46:48.713000','Mai Ngọc Tùng Sơn','ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_pay`
--

DROP TABLE IF EXISTS `time_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_pay` (
  `id` bigint NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `delete_flag` bit(1) DEFAULT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `type_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_pay`
--

LOCK TABLES `time_pay` WRITE;
/*!40000 ALTER TABLE `time_pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKlkhooy5w45r7bji6wv27a0wuq` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-09 23:52:37
