-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08-Jul-2019 às 18:25
-- Versão do servidor: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdsistemaos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_os`
--

CREATE TABLE `item_os` (
  `idItemOs` int(11) NOT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `idOs` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `item_os`
--

INSERT INTO `item_os` (`idItemOs`, `idProduto`, `idOs`) VALUES
(14, 10, 14),
(15, 11, 14);

-- --------------------------------------------------------

--
-- Estrutura da tabela `os`
--

CREATE TABLE `os` (
  `codigo` int(11) NOT NULL,
  `dataEmissao` date DEFAULT NULL,
  `servico` varchar(250) DEFAULT NULL,
  `situacao` varchar(20) DEFAULT 'ABERTA',
  `valorServico` double DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `idSetor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `os`
--

INSERT INTO `os` (`codigo`, `dataEmissao`, `servico`, `situacao`, `valorServico`, `descricao`, `idSetor`) VALUES
(14, '2019-07-08', 'Teste', 'ABERTA', 50, 'Testando', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `codigoProduto` int(11) NOT NULL,
  `nomeProduto` varchar(50) DEFAULT NULL,
  `marca` varchar(30) DEFAULT NULL,
  `numeroSerie` varchar(20) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `preco` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`codigoProduto`, `nomeProduto`, `marca`, `numeroSerie`, `descricao`, `quantidade`, `preco`) VALUES
(10, 'Impressora Teste', 'Teste', 'TST201901', 'Impressora teste', 2, 50),
(11, 'Notebook', 'Lenovo', '123456', '', 2, 1500);

-- --------------------------------------------------------

--
-- Estrutura da tabela `setor`
--

CREATE TABLE `setor` (
  `idSetor` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `telefone` char(11) DEFAULT NULL,
  `responsavel` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `setor`
--

INSERT INTO `setor` (`idSetor`, `nome`, `endereco`, `telefone`, `responsavel`) VALUES
(5, 'Secretaria de educação', 'Rua testando, 123', '9 9195-4885', 'Marcos');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item_os`
--
ALTER TABLE `item_os`
  ADD PRIMARY KEY (`idItemOs`),
  ADD KEY `item_os_ibfk_1` (`idProduto`),
  ADD KEY `item_os_ibfk_2` (`idOs`);

--
-- Indexes for table `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `os_ibfk_1` (`idSetor`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`codigoProduto`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`idSetor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item_os`
--
ALTER TABLE `item_os`
  MODIFY `idItemOs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `os`
--
ALTER TABLE `os`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `codigoProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `idSetor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `item_os`
--
ALTER TABLE `item_os`
  ADD CONSTRAINT `item_os_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produtos` (`codigoProduto`),
  ADD CONSTRAINT `item_os_ibfk_2` FOREIGN KEY (`idOs`) REFERENCES `os` (`codigo`);

--
-- Limitadores para a tabela `os`
--
ALTER TABLE `os`
  ADD CONSTRAINT `os_ibfk_1` FOREIGN KEY (`idSetor`) REFERENCES `setor` (`idSetor`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
