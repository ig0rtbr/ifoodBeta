-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: dbupdelivery
-- ------------------------------------------------------
-- Server version	5.7.36

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
-- Table structure for table `forcenedor`
--

DROP TABLE IF EXISTS `forcenedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forcenedor` (
  `idForcenedor` int(11) NOT NULL AUTO_INCREMENT,
  `idDono` int(11) NOT NULL,
  `nomeForcenedor` varchar(40) NOT NULL,
  `nomeFantasia` varchar(40) NOT NULL,
  `razaoSocial` varchar(40) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `tipoComercio` varchar(30) NOT NULL,
  `rua` varchar(60) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `precoPorKm` decimal(5,2) NOT NULL,
  PRIMARY KEY (`idForcenedor`),
  UNIQUE KEY `razaoSocial` (`razaoSocial`),
  UNIQUE KEY `cnpj` (`cnpj`),
  KEY `idDono` (`idDono`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forcenedor`
--

LOCK TABLES `forcenedor` WRITE;
/*!40000 ALTER TABLE `forcenedor` DISABLE KEYS */;
INSERT INTO `forcenedor` VALUES (1,1,'BEBIDAS E CIA','NOME FANTASIA','RAZAO SOCIAl','1597485','BEBIDAS','PRINCIPE','312','440602302',0.50);
/*!40000 ALTER TABLE `forcenedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `sobrenome` varchar(60) NOT NULL,
  `cpf` varchar(13) NOT NULL,
  `dataNascimento` date NOT NULL,
  `rua` varchar(60) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `login` (`login`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'igor','Pereira II','123','2000-12-04','Ruda linda','658','915845','igor123','123'),(3,'Igor','Pereira III','1234','2000-12-04','Ruda linda','658','915845','igor1234','123');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `fornecedorResponsavel` int(11) NOT NULL,
  `nomeProduto` varchar(40) NOT NULL,
  `descricaoProduto` text,
  `dataFabricacao` date DEFAULT NULL,
  `dataValidade` date DEFAULT NULL,
  `codigoBarras` varchar(13) DEFAULT NULL,
  `tipoProduto` varchar(30) NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `desconto` decimal(3,2) DEFAULT '0.00',
  PRIMARY KEY (`idproduto`),
  KEY `fornecedorResponsavel` (`fornecedorResponsavel`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `idToken` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `idUsario` int(11) NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataValidade` date NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idToken`),
  KEY `idUsario` (`idUsario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-18 21:19:43
