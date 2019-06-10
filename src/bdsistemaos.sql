-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11-Jun-2019 às 01:22
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
-- Estrutura da tabela `os`
--

CREATE TABLE `os` (
  `codigo` int(11) NOT NULL,
  `dataEmissao` date DEFAULT NULL,
  `servico` varchar(250) DEFAULT NULL,
  `situacao` varchar(20) DEFAULT 'ABERTA',
  `valorServico` double DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `codigoProduto` int(11) DEFAULT NULL,
  `idSetor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `os`
--

INSERT INTO `os` (`codigo`, `dataEmissao`, `servico`, `situacao`, `valorServico`, `descricao`, `codigoProduto`, `idSetor`) VALUES
(1, '2019-05-18', 'Troca de fone', 'ABERTA', 25, '', 7, 1),
(2, '2019-05-18', 'Troca de fonte', 'ABERTA', 30, '', 8, 1),
(3, '2019-05-18', 'Troca da carcaça', 'ABERTA', 25, '', 7, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `marca` varchar(30) DEFAULT NULL,
  `numeroSerie` varchar(20) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `preco` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`codigo`, `nome`, `marca`, `numeroSerie`, `descricao`, `quantidade`, `preco`) VALUES
(7, 'Caixa de som', 'Goldentec', 'GOLD201901', 'GTMUSIC', 3, 40),
(8, 'Roteador', 'IntelBras', 'ITS201901', '150 Mbps', 4, 100);

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
(1, 'Secretária de Saúde', 'Rua das secretarias, 70, Centro ', '9 9195-4885', 'José das Secretarias'),
(3, 'Secretaria de educação', 'Rua das secretarias', '9 9195-4885', 'José dos esportes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codigoProduto` (`codigoProduto`),
  ADD KEY `idSetor` (`idSetor`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`idSetor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `os`
--
ALTER TABLE `os`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `idSetor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `os`
--
ALTER TABLE `os`
  ADD CONSTRAINT `os_ibfk_1` FOREIGN KEY (`codigoProduto`) REFERENCES `produtos` (`codigo`),
  ADD CONSTRAINT `os_ibfk_2` FOREIGN KEY (`idSetor`) REFERENCES `setor` (`idSetor`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
