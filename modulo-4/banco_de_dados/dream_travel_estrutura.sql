-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dream_travel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `cpf` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `senha` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `companhia_aerea`
--

DROP TABLE IF EXISTS `companhia_aerea`;
CREATE TABLE IF NOT EXISTS `companhia_aerea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

DROP TABLE IF EXISTS `contato`;
CREATE TABLE IF NOT EXISTS `contato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mensagem` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `destino`
--

DROP TABLE IF EXISTS `destino`;
CREATE TABLE IF NOT EXISTS `destino` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descricao` text NOT NULL,
  `localizacao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `preco_medio` double DEFAULT NULL,
  `internacional` tinyint(1) NOT NULL,
  `imagem` mediumblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `forma_pagamento`
--

DROP TABLE IF EXISTS `forma_pagamento`;
CREATE TABLE IF NOT EXISTS `forma_pagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `passagem`
--

DROP TABLE IF EXISTS `passagem`;
CREATE TABLE IF NOT EXISTS `passagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_partida` date DEFAULT NULL,
  `origem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `fk_destino_id` int DEFAULT NULL,
  `fk_promocao_id` int DEFAULT NULL,
  `fk_companhia_aerea_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Passagem_2` (`fk_destino_id`),
  KEY `FK_Passagem_3` (`fk_promocao_id`),
  KEY `FK_Passagem_4` (`fk_companhia_aerea_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_compra` date DEFAULT NULL,
  `hora_compra` time NOT NULL,
  `preco_compra` double DEFAULT NULL,
  `fk_cliente_cpf` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `fk_passagem_id` int DEFAULT NULL,
  `fk_forma_pagamento_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Pedido_2` (`fk_cliente_cpf`),
  KEY `FK_Pedido_3` (`fk_passagem_id`),
  KEY `FK_Pedido_4` (`fk_forma_pagamento_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocao`
--

DROP TABLE IF EXISTS `promocao`;
CREATE TABLE IF NOT EXISTS `promocao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `fk_destino_id` int DEFAULT NULL,
  `destino_id` int DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Promocoes_2` (`fk_destino_id`),
  KEY `FKkl7rklhor08dwexr0kdwef7n` (`destino_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `passagem`
--
ALTER TABLE `passagem`
  ADD CONSTRAINT `FK_Passagem_2` FOREIGN KEY (`fk_destino_id`) REFERENCES `destino` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_Passagem_3` FOREIGN KEY (`fk_promocao_id`) REFERENCES `promocao` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `FK_Passagem_4` FOREIGN KEY (`fk_companhia_aerea_Id`) REFERENCES `companhia_aerea` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_Pedido_2` FOREIGN KEY (`fk_cliente_cpf`) REFERENCES `cliente` (`cpf`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_Pedido_3` FOREIGN KEY (`fk_passagem_id`) REFERENCES `passagem` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_Pedido_4` FOREIGN KEY (`fk_forma_pagamento_Id`) REFERENCES `forma_pagamento` (`id`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `promocao`
--
ALTER TABLE `promocao`
  ADD CONSTRAINT `FK_Promocoes_2` FOREIGN KEY (`fk_destino_id`) REFERENCES `destino` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKkl7rklhor08dwexr0kdwef7n` FOREIGN KEY (`destino_id`) REFERENCES `destino` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
