-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 11 Mai 2014 à 17:14
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `reconnaissancefaciale`
--

-- --------------------------------------------------------

--
-- Structure de la table `information`
--

CREATE TABLE IF NOT EXISTS `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `dateDeNaissance` date NOT NULL,
  `ville` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `remarque` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `information`
--

INSERT INTO `information` (`id`, `idUtilisateur`, `nom`, `prenom`, `dateDeNaissance`, `ville`, `pays`, `remarque`) VALUES
(1, 1, 'perraudeau', 'victor', '1990-12-31', 'aizenay', 'france', 'le meilleur'),
(2, 2, 'Le roux', 'Alexis', '2014-01-21', 'LA BOISSIERE LOL', 'maroc', ''),
(16, 21, 'Chevillard', 'Paul-Henry', '1900-01-01', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

CREATE TABLE IF NOT EXISTS `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur` int(11) NOT NULL,
  `idInformation` int(11) NOT NULL,
  `photoStream` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `niveauUtilisateur` int(11) NOT NULL DEFAULT '0',
  `dateInscription` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `password`, `email`, `niveauUtilisateur`, `dateInscription`) VALUES
(1, '88fa846e5f8aa198848be76e1abdcb7d7a42d292', 'alice@example.com', 1, '0000-00-00 00:00:00'),
(2, '37ac5e111a9b2f779e373f78efa4f7678b93feb1', 'bob@example.com', 2, '0000-00-00 00:00:00'),
(21, 'e9efe2aea5ad46614d39e809e89207fa6f915ffe', 'carl@example.com', 1, '2014-03-23 23:07:13');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `information`
--
ALTER TABLE `information`
  ADD CONSTRAINT `information_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
