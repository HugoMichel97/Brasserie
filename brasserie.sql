-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 08 avr. 2022 à 14:34
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
  `client_fk` int(11) NOT NULL,
  `produit_fk` int(11) NOT NULL,
  PRIMARY KEY (`id_achat`),
  KEY `achat_client_fk` (`client_fk`),
  KEY `achat_produit_fk` (`produit_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`id_achat`, `quantite`, `version`, `client_fk`, `produit_fk`) VALUES
(1, 3, 0, 2, 2),
(2, 10, 0, 3, 1),
(3, 5, 0, 3, 2),
(4, 2, 0, 4, 1),
(5, 2, 0, 5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `brasseur`
--

DROP TABLE IF EXISTS `brasseur`;
CREATE TABLE IF NOT EXISTS `brasseur` (
  `id` int(11) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `password` varchar(225) NOT NULL,
  `version` int(11) NOT NULL,
  `depenses` double NOT NULL,
  `recettes` double NOT NULL,
  `tresorerie` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_816u8hx5qtnqotwaublr57nqn` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `brasseur`
--

INSERT INTO `brasseur` (`id`, `mail`, `password`, `version`, `depenses`, `recettes`, `tresorerie`) VALUES
(1, 'arthur@aminagomo.fr', '$2a$10$I0Ot4FVXePHEJZniWaSF8u3ewQINORevONPSlyEahjkIrBI/Ye4/2', 0, 150, 200, 1000);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `password` varchar(225) NOT NULL,
  `version` int(11) NOT NULL,
  `fidelite` int(11) NOT NULL,
  `date_naissance` date NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `statut` enum('vide','en_attente','validee','prete','recuperee') DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sl0fhqdec6m4pbqb5qaqk43qk` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `mail`, `password`, `version`, `fidelite`, `date_naissance`, `nom`, `prenom`, `statut`, `tel`) VALUES
(2, 'hugo@michel', '$2a$10$9t1wxFi8H0XPk0Kqr4/sZuNO.ZAC9Vxd49G0tG8UO86yUiegrLH7C', 0, 10, '1997-01-01', 'Michel', 'Hugo', 'vide', NULL),
(3, 'amine@berrada', '$2a$10$94jocmbASnKUXPRuGkorMOg2OPhbHgSDhN.kVeQMFwMvyq4DJMNzW', 0, 5000, '1997-01-01', 'Berrada', 'Amine', 'vide', '0643675489'),
(4, 'mohamed@khamassi', '$2a$10$ltgCo6fuDzRzlVOFL8oVROgKhp9P.zHc7ch6ASaMIZH2v7GvO8Lj2', 0, 50, '1997-01-01', 'Khamassi', 'Mohamed', 'en_attente', '0642424242'),
(5, 'anais@lharidon', '$2a$10$SgHQ927Uv5ffaZQGja/c2Obw0XAaVfuC4se4gjXmpBjeiz.p8dR.u', 0, 10, '1997-05-01', 'L\'Haridon', 'Anaïs', 'prete', '0687945632');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_evenement` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `heure` time NOT NULL,
  `libelle` varchar(25) DEFAULT NULL,
  `places` int(11) DEFAULT NULL,
  `prix` double NOT NULL,
  `pts_requis` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_evenement`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_evenement`, `date`, `description`, `heure`, `libelle`, `places`, `prix`, `pts_requis`, `version`) VALUES
(1, '2022-04-08', 'Inauguration de la merveilleuse brasserie Aminagomo', '16:29:12', 'Inauguration', 3, 2, 0, 0),
(2, '2022-05-01', 'Degustation de bières de la brasserie acompagnées de fromages locaux', '18:00:00', 'Degustation', 4, 30, 10, 0);

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
('default', 6);

-- --------------------------------------------------------

--
-- Structure de la table `info_reglement`
--

DROP TABLE IF EXISTS `info_reglement`;
CREATE TABLE IF NOT EXISTS `info_reglement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_valid` varchar(5) NOT NULL,
  `identifiant_paypal` varchar(100) NOT NULL,
  `mode` enum('CB','PayPal') NOT NULL,
  `nom` varchar(50) NOT NULL,
  `num` varchar(16) NOT NULL,
  `version` int(11) NOT NULL,
  `client_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reglement_client_fk` (`client_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `info_reglement`
--

INSERT INTO `info_reglement` (`id`, `date_valid`, `identifiant_paypal`, `mode`, `nom`, `num`, `version`, `client_fk`) VALUES
(1, '03/23', '', 'CB', 'Khamassi', '4242424242424242', 0, 4),
(2, '', 'anais@lharidon', 'PayPal', '', '', 0, 5);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id_ingredient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_ingredient`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `nom`, `stock`, `version`) VALUES
(1, 'Malt d\'orge bio', 100, 0),
(2, 'Blé cru bio', 100, 0),
(3, 'Purée de fruits rouge bios', 100, 0);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id_note` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(300) DEFAULT NULL,
  `note` double NOT NULL,
  `version` int(11) NOT NULL,
  `id_biere` int(11) NOT NULL,
  `id_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_note`),
  KEY `note_biere_fk` (`id_biere`),
  KEY `note_client_fk` (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`id_note`, `commentaire`, `note`, `version`, `id_biere`, `id_client`) VALUES
(1, NULL, 3, 0, 2, 2),
(2, 'Très bonne bière', 5, 0, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `type_produit` enum('Biere','Snack') NOT NULL,
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(300) DEFAULT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `points` int(11) NOT NULL,
  `prix` double NOT NULL,
  `stock` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`type_produit`, `id_produit`, `description`, `nom`, `points`, `prix`, `stock`, `version`) VALUES
('Snack', 1, 'Bouchée acidulée et fondante', 'Moelleux au citron', 0, 4.5, 15, 0),
('Biere', 2, 'Bière aux fruits rouge', 'Mirador', 10, 9, 500, 0);

-- --------------------------------------------------------

--
-- Structure de la table `recettes`
--

DROP TABLE IF EXISTS `recettes`;
CREATE TABLE IF NOT EXISTS `recettes` (
  `id_biere` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL,
  KEY `recettes_ingredient_fk` (`id_ingredient`),
  KEY `recettes_biere_fk` (`id_biere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `recettes`
--

INSERT INTO `recettes` (`id_biere`, `id_ingredient`) VALUES
(2, 1),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL,
  `participants` int(11) DEFAULT NULL,
  `statut` enum('en_attente','validee') DEFAULT NULL,
  `version` int(11) NOT NULL,
  `client_fk` int(11) NOT NULL,
  `evt_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reservation_client_fk` (`client_fk`),
  KEY `reservation_evt_fk` (`evt_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `participants`, `statut`, `version`, `client_fk`, `evt_fk`) VALUES
(1, 1, 'validee', 0, 2, 2),
(2, 1, 'en_attente', 0, 3, 1),
(3, 1, 'validee', 0, 3, 2),
(4, 1, 'validee', 0, 4, 2),
(5, 1, 'validee', 0, 5, 2),
(6, 2, 'en_attente', 0, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seq_comptes`
--

DROP TABLE IF EXISTS `seq_comptes`;
CREATE TABLE IF NOT EXISTS `seq_comptes` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seq_comptes`
--

INSERT INTO `seq_comptes` (`next_val`) VALUES
(6);

-- --------------------------------------------------------

--
-- Structure de la table `suggestions`
--

DROP TABLE IF EXISTS `suggestions`;
CREATE TABLE IF NOT EXISTS `suggestions` (
  `id_biere` int(11) NOT NULL,
  `id_snack` int(11) NOT NULL,
  KEY `suggestions_snack_fk` (`id_snack`),
  KEY `suggestions_biere_fk` (`id_biere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `suggestions`
--

INSERT INTO `suggestions` (`id_biere`, `id_snack`) VALUES
(2, 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `achat_client_fk` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `achat_produit_fk` FOREIGN KEY (`produit_fk`) REFERENCES `produit` (`id_produit`);

--
-- Contraintes pour la table `info_reglement`
--
ALTER TABLE `info_reglement`
  ADD CONSTRAINT `reglement_client_fk` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_biere_fk` FOREIGN KEY (`id_biere`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `note_client_fk` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `recettes`
--
ALTER TABLE `recettes`
  ADD CONSTRAINT `recettes_biere_fk` FOREIGN KEY (`id_biere`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `recettes_ingredient_fk` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_client_fk` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `reservation_evt_fk` FOREIGN KEY (`evt_fk`) REFERENCES `evenement` (`id_evenement`);

--
-- Contraintes pour la table `suggestions`
--
ALTER TABLE `suggestions`
  ADD CONSTRAINT `suggestions_biere_fk` FOREIGN KEY (`id_biere`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `suggestions_snack_fk` FOREIGN KEY (`id_snack`) REFERENCES `produit` (`id_produit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
