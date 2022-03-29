-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 29 mars 2022 à 13:23
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `brasserie`
--
CREATE DATABASE IF NOT EXISTS `brasserie` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `brasserie`;

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

DROP TABLE IF EXISTS `achat`;
CREATE TABLE IF NOT EXISTS `achat` (
  `id_achat` int(11) NOT NULL AUTO_INCREMENT,
  `quantite` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `client_fk` int(11) DEFAULT NULL,
  `produit_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_achat`),
  KEY `FKpts8yrgevhoo84fauo74y3rvw` (`client_fk`),
  KEY `FK33327krvao4v88fcaiy8ej71x` (`produit_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`id_achat`, `quantite`, `version`, `client_fk`, `produit_fk`) VALUES
(1, 1, 0, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `brasseur`
--

DROP TABLE IF EXISTS `brasseur`;
CREATE TABLE IF NOT EXISTS `brasseur` (
  `id` int(11) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `depenses` double NOT NULL,
  `recettes` double NOT NULL,
  `tresorerie` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_p80gxt8eu77csi1i2c7bfb8pk` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `brasseur`
--

INSERT INTO `brasseur` (`id`, `mail`, `password`, `version`, `depenses`, `recettes`, `tresorerie`) VALUES
(3, 'Arthur@test', 'brasseur', 0, 5, 15, 10);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `fidelite` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7saae44x6o7o8l9kmloawbbwx` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `mail`, `password`, `version`, `fidelite`, `nom`, `prenom`, `tel`) VALUES
(1, 'Jonh@Doe', 'client', 0, 5, NULL, NULL, '0987'),
(2, 'Hugo@Michel', 'client', 0, 20, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_evenement` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `heure` time DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL,
  `ptsRequis` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_evenement`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_evenement`, `date`, `description`, `heure`, `libelle`, `prix`, `ptsRequis`, `version`) VALUES
(1, '2022-03-29', NULL, '15:18:00', 'Test', 13.8, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `next_val`) VALUES
('default', 4);

-- --------------------------------------------------------

--
-- Structure de la table `info_reglement`
--

DROP TABLE IF EXISTS `info_reglement`;
CREATE TABLE IF NOT EXISTS `info_reglement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateValid` varchar(255) DEFAULT NULL,
  `mode` enum('CB','PayPal') DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `client_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK89m9dk1n0both2iy7kba3o10j` (`client_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `info_reglement`
--

INSERT INTO `info_reglement` (`id`, `dateValid`, `mode`, `nom`, `num`, `version`, `client_fk`) VALUES
(1, '06/24', 'CB', 'Hugo', '123', 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id_ingredient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_ingredient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `nom`, `stock`, `version`) VALUES
(1, 'Houblon', 50, 0),
(2, 'Levure', 3, 0);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id_note` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(255) DEFAULT NULL,
  `note` double NOT NULL,
  `version` int(11) NOT NULL,
  `id_biere` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_note`),
  KEY `FKhv5ldoqyr6n0kfha1gpiark3b` (`id_biere`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`id_note`, `commentaire`, `note`, `version`, `id_biere`) VALUES
(1, 'Test', 5, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `type_produit` enum('Biere','Snack') NOT NULL,
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`type_produit`, `id_produit`, `description`, `nom`, `points`, `prix`, `stock`, `version`) VALUES
('Biere', 1, NULL, 'Test', 0, 3.5, 0, 0),
('Snack', 2, NULL, 'Test', NULL, 2, 0, 0),
('Snack', 3, NULL, 'Moelleux citron', 0, 6, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `recettes`
--

DROP TABLE IF EXISTS `recettes`;
CREATE TABLE IF NOT EXISTS `recettes` (
  `id_biere` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL,
  KEY `FKrynqbt8pl8xkyf9h6k8i0bg22` (`id_ingredient`),
  KEY `FKu6fjw78h7nwe5ekbsmc3jsgn` (`id_biere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `recettes`
--

INSERT INTO `recettes` (`id_biere`, `id_ingredient`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `client_fk` int(11) DEFAULT NULL,
  `evt_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35tpby9o9ir5jrtm1511vbngi` (`client_fk`),
  KEY `FKex84s4sgqou9jd337yu1gl4g7` (`evt_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `version`, `client_fk`, `evt_fk`) VALUES
(1, 0, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `suggestions`
--

DROP TABLE IF EXISTS `suggestions`;
CREATE TABLE IF NOT EXISTS `suggestions` (
  `id_biere` int(11) NOT NULL,
  `id_snack` int(11) NOT NULL,
  KEY `FKf99lvdredhf8velniyakb6hpg` (`id_snack`),
  KEY `FK1ocmkecafdhjaag2ybdwr4kdj` (`id_biere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `suggestions`
--

INSERT INTO `suggestions` (`id_biere`, `id_snack`) VALUES
(1, 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `FK33327krvao4v88fcaiy8ej71x` FOREIGN KEY (`produit_fk`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `FKpts8yrgevhoo84fauo74y3rvw` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `info_reglement`
--
ALTER TABLE `info_reglement`
  ADD CONSTRAINT `FK89m9dk1n0both2iy7kba3o10j` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `FKhv5ldoqyr6n0kfha1gpiark3b` FOREIGN KEY (`id_biere`) REFERENCES `produit` (`id_produit`);

--
-- Contraintes pour la table `recettes`
--
ALTER TABLE `recettes`
  ADD CONSTRAINT `FKrynqbt8pl8xkyf9h6k8i0bg22` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`),
  ADD CONSTRAINT `FKu6fjw78h7nwe5ekbsmc3jsgn` FOREIGN KEY (`id_biere`) REFERENCES `produit` (`id_produit`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK35tpby9o9ir5jrtm1511vbngi` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKex84s4sgqou9jd337yu1gl4g7` FOREIGN KEY (`evt_fk`) REFERENCES `evenement` (`id_evenement`);

--
-- Contraintes pour la table `suggestions`
--
ALTER TABLE `suggestions`
  ADD CONSTRAINT `FK1ocmkecafdhjaag2ybdwr4kdj` FOREIGN KEY (`id_biere`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `FKf99lvdredhf8velniyakb6hpg` FOREIGN KEY (`id_snack`) REFERENCES `produit` (`id_produit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
