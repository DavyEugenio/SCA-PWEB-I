-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 22-Ago-2019 às 05:00
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `sage` varchar(9) COLLATE latin1_general_cs NOT NULL,
  `id_turma` int(9) NOT NULL,
  `nome` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `senha` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `status` varchar(100) COLLATE latin1_general_cs NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`sage`, `id_turma`, `nome`, `senha`, `status`) VALUES
('123', 5, 'Rita Lee', '123', 'Formado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id` int(9) NOT NULL,
  `nome` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `modalidade` varchar(100) COLLATE latin1_general_cs NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id`, `nome`, `modalidade`) VALUES
(6, 'Informatica', 'Medio Integrado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `frequencia`
--

CREATE TABLE `frequencia` (
  `id` int(9) NOT NULL,
  `sage_aluno` varchar(9) COLLATE latin1_general_cs NOT NULL,
  `entrada` datetime NOT NULL,
  `saida` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Extraindo dados da tabela `frequencia`
--

INSERT INTO `frequencia` (`id`, `sage_aluno`, `entrada`, `saida`) VALUES
(68, '123', '2019-08-04 14:12:17', '2019-08-07 16:41:42'),
(69, '123', '2019-08-08 00:14:24', '2019-08-08 00:14:26'),
(70, '123', '2019-08-12 03:10:44', '2019-08-12 03:10:45'),
(71, '123', '2019-08-12 03:10:47', '2019-08-12 03:10:48'),
(72, '123', '2019-08-12 03:11:14', '2019-08-12 03:11:16'),
(73, '123', '2019-08-12 03:11:18', '2019-08-12 03:11:19'),
(76, '123', '2019-08-18 16:49:35', '2019-08-18 16:49:45'),
(77, '123', '2019-08-21 22:49:21', '2019-08-21 22:56:42');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servidor`
--

CREATE TABLE `servidor` (
  `siape` varchar(9) COLLATE latin1_general_cs NOT NULL,
  `nome` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `senha` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `funcao` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `classe` varchar(100) COLLATE latin1_general_cs NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Extraindo dados da tabela `servidor`
--

INSERT INTO `servidor` (`siape`, `nome`, `senha`, `funcao`, `classe`) VALUES
('123', 'Dolores Goncalves Costa', '123', 'Atriz', 'servidor'),
('admin', 'Padrão', 'admin', 'Gerenciador', 'operador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `id` int(9) NOT NULL,
  `id_curso` int(9) NOT NULL,
  `ano` int(4) NOT NULL,
  `semestre` int(2) NOT NULL,
  `turno` varchar(10) COLLATE latin1_general_cs NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`id`, `id_curso`, `ano`, `semestre`, `turno`) VALUES
(5, 6, 2019, 2, 'Vespertino'),
(6, 6, 2020, 2, 'Vespertino');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`sage`),
  ADD KEY `fk2` (`id_turma`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `frequencia`
--
ALTER TABLE `frequencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk3` (`sage_aluno`);

--
-- Indexes for table `servidor`
--
ALTER TABLE `servidor`
  ADD PRIMARY KEY (`siape`);

--
-- Indexes for table `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1` (`id_curso`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `curso`
--
ALTER TABLE `curso`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `frequencia`
--
ALTER TABLE `frequencia`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `turma`
--
ALTER TABLE `turma`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `frequencia`
--
ALTER TABLE `frequencia`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`sage_aluno`) REFERENCES `aluno` (`sage`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
