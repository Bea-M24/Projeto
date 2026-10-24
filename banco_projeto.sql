-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `tab_cliente`
--

DROP TABLE IF EXISTS `tab_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_cliente`
--

LOCK TABLES `tab_cliente` WRITE;
/*!40000 ALTER TABLE `tab_cliente` DISABLE KEYS */;
INSERT INTO `tab_cliente` VALUES (2,'beatriz@gmail.com','Bahia','Beatriz','7199999-9999');
/*!40000 ALTER TABLE `tab_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_fornecedores`
--

DROP TABLE IF EXISTS `tab_fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_fornecedores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `razao_social` varchar(255) DEFAULT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_fornecedores`
--

LOCK TABLES `tab_fornecedores` WRITE;
/*!40000 ALTER TABLE `tab_fornecedores` DISABLE KEYS */;
INSERT INTO `tab_fornecedores` VALUES (1,'pet@gmail.com','7199999-9999','SenaiPetshop Distribuidora','123456789101112');
/*!40000 ALTER TABLE `tab_fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_funcionarios`
--

DROP TABLE IF EXISTS `tab_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_funcionarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `data_admissao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_funcionarios`
--

LOCK TABLES `tab_funcionarios` WRITE;
/*!40000 ALTER TABLE `tab_funcionarios` DISABLE KEYS */;
INSERT INTO `tab_funcionarios` VALUES (1,'Gabriele@gmail.com','Atendente','Gabriele','24/10/2026');
/*!40000 ALTER TABLE `tab_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_pets`
--

DROP TABLE IF EXISTS `tab_pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_pets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtas8rivh0enb8o55dxecllb90` (`cliente_id`),
  CONSTRAINT `FKtas8rivh0enb8o55dxecllb90` FOREIGN KEY (`cliente_id`) REFERENCES `tab_cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_pets`
--

LOCK TABLES `tab_pets` WRITE;
/*!40000 ALTER TABLE `tab_pets` DISABLE KEYS */;
INSERT INTO `tab_pets` VALUES (1,'Ruan','Gato','SRD',2),(2,'Ruan','Gato','SRD',2);
/*!40000 ALTER TABLE `tab_pets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_produtos`
--

DROP TABLE IF EXISTS `tab_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `estoque` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_produtos`
--

LOCK TABLES `tab_produtos` WRITE;
/*!40000 ALTER TABLE `tab_produtos` DISABLE KEYS */;
INSERT INTO `tab_produtos` VALUES (1,'Ração para cães','Ração',50.9,25);
/*!40000 ALTER TABLE `tab_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_servicos`
--

DROP TABLE IF EXISTS `tab_servicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_servicos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `duracao_minutos` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_servicos`
--

LOCK TABLES `tab_servicos` WRITE;
/*!40000 ALTER TABLE `tab_servicos` DISABLE KEYS */;
INSERT INTO `tab_servicos` VALUES (1,'Banho completo no pet','Banho',130,60);
/*!40000 ALTER TABLE `tab_servicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_usuario`
--

DROP TABLE IF EXISTS `tab_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_usuario`
--

LOCK TABLES `tab_usuario` WRITE;
/*!40000 ALTER TABLE `tab_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-24  1:20:25
