-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 24 juil. 2023 à 21:46
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gid_system`
--

-- --------------------------------------------------------

--
-- Structure de la table `deponse`
--

CREATE TABLE `deponse` (
  `nomber` varchar(200) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `dateCr` date NOT NULL DEFAULT current_timestamp(),
  `dateSn` date DEFAULT NULL,
  `statut` varchar(100) NOT NULL DEFAULT 'Créer'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `deponse`
--

INSERT INTO `deponse` (`nomber`, `type`, `dateCr`, `dateSn`, `statut`) VALUES
('13', 'Versement', '2023-06-12', NULL, 'Créer'),
('7', 'Marché', '2023-06-11', '2023-06-12', 'Valide'),
('8', 'Bon de cammand', '2023-06-11', '2023-06-12', 'Visa'),
('9', 'Bon de cammand', '2023-06-11', NULL, 'Créer'),
('999', 'Bon de cammand', '2023-06-23', NULL, 'Rensigne');

-- --------------------------------------------------------

--
-- Structure de la table `gestionengagement`
--

CREATE TABLE `gestionengagement` (
  `CodeBudgetair` int(11) NOT NULL,
  `NatureCredit` varchar(100) DEFAULT NULL,
  `montant` int(11) DEFAULT NULL,
  `deponse_nomber` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gestionengagement`
--

INSERT INTO `gestionengagement` (`CodeBudgetair`, `NatureCredit`, `montant`, `deponse_nomber`) VALUES
(1010104043, 'Crédit d\'engagement', 6000, '7'),
(1010104043, 'Crédit de paiement', 1300, '999');

-- --------------------------------------------------------

--
-- Structure de la table `justification`
--

CREATE TABLE `justification` (
  `id` int(11) NOT NULL,
  `deponse_nomber` varchar(200) NOT NULL,
  `decsription` varchar(200) NOT NULL,
  `filepath` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `justification`
--

INSERT INTO `justification` (`id`, `deponse_nomber`, `decsription`, `filepath`) VALUES
(5, '7', '', 'C:\\Users\\LENOVO\\Documents\\BTS\\Prof. Ziani\\Ordonnancement\\cours\\ORDONNNANCEMENT.pdf'),
(6, '8', '', 'C:\\Users\\LENOVO\\Documents\\BTS\\Prof. Ziani\\Ordonnancement\\cours\\ORDONNNANCEMENT.pdf');

-- --------------------------------------------------------

--
-- Structure de la table `logintable`
--

CREATE TABLE `logintable` (
  `cin` varchar(50) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sexe` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `logintable`
--

INSERT INTO `logintable` (`cin`, `nom`, `prenom`, `login`, `password`, `sexe`, `type`) VALUES
('ZT11111', 'Admin ', 'Admin ', 'admin', 'admin', 'Masculin', 'Gouverneur'),
('ZT22222', 'Utilisateur', 'Utilisateur', 'utili', 'utili', 'Masculin', 'Utilisateur'),
('ZT33333', 'Comptable', 'Comptable', 'comp', 'comp', 'Masculin', 'Comptable');

-- --------------------------------------------------------

--
-- Structure de la table `parcodebudgetaire`
--

CREATE TABLE `parcodebudgetaire` (
  `id` int(11) NOT NULL,
  `nameType` int(150) NOT NULL,
  `decsription` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parcodebudgetaire`
--

INSERT INTO `parcodebudgetaire` (`id`, `nameType`, `decsription`) VALUES
(6, 1010102022, 'Location de matériel des fetes'),
(7, 1010102025, 'Fraisd\'animation artistiques'),
(8, 1010104043, 'Frais de mission à l\'étranger');

-- --------------------------------------------------------

--
-- Structure de la table `pardeponse`
--

CREATE TABLE `pardeponse` (
  `id` int(11) NOT NULL,
  `nameType` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pardeponse`
--

INSERT INTO `pardeponse` (`id`, `nameType`) VALUES
(3, 'Marché'),
(4, 'Bon de cammand'),
(5, 'Versement'),
(6, 'Avances');

-- --------------------------------------------------------

--
-- Structure de la table `parmodepaim`
--

CREATE TABLE `parmodepaim` (
  `id` int(11) NOT NULL,
  `nameType` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parmodepaim`
--

INSERT INTO `parmodepaim` (`id`, `nameType`) VALUES
(2, 'Paiement à terme échu'),
(3, 'Paiement anticipé'),
(4, 'Paiement par acomptes'),
(5, 'Paiement par lettre de crédit');

-- --------------------------------------------------------

--
-- Structure de la table `parnatureprix`
--

CREATE TABLE `parnatureprix` (
  `id` int(11) NOT NULL,
  `nameType` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parnatureprix`
--

INSERT INTO `parnatureprix` (`id`, `nameType`) VALUES
(2, 'Prix unitaire'),
(3, 'Prix global forfaitaire '),
(4, 'Prix révisables'),
(5, 'Prix mixtes');

-- --------------------------------------------------------

--
-- Structure de la table `parpassation`
--

CREATE TABLE `parpassation` (
  `id` int(11) NOT NULL,
  `nameType` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parpassation`
--

INSERT INTO `parpassation` (`id`, `nameType`) VALUES
(2, 'Appel d\'offres'),
(3, 'Dialogue compétitif '),
(4, 'Marché négocié'),
(5, 'Marché de gré à gré');

-- --------------------------------------------------------

--
-- Structure de la table `partypetiers`
--

CREATE TABLE `partypetiers` (
  `id` int(11) NOT NULL,
  `nameType` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `partypetiers`
--

INSERT INTO `partypetiers` (`id`, `nameType`) VALUES
(2, 'Pouvoir adjudicateur'),
(3, 'Fournisseurs ou soumissionnaires'),
(4, 'Sous-traitants'),
(5, 'Contrôleur');

-- --------------------------------------------------------

--
-- Structure de la table `quantiteetvalue`
--

CREATE TABLE `quantiteetvalue` (
  `id` int(11) NOT NULL,
  `disignation` varchar(250) DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `prixUnitaire` double DEFAULT NULL,
  `valeurTva` varchar(50) DEFAULT NULL,
  `totalHt` double DEFAULT NULL,
  `totalttc` double NOT NULL,
  `deponse_nomber` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `quantiteetvalue`
--

INSERT INTO `quantiteetvalue` (`id`, `disignation`, `quantite`, `prixUnitaire`, `valeurTva`, `totalHt`, `totalttc`, `deponse_nomber`) VALUES
(12, 'Disignation', 12, 120, '7% TVA', 1440, 1540.8, '7'),
(13, 'azer', 12, 1000, '7% TVA', 12000, 12840, '8');

-- --------------------------------------------------------

--
-- Structure de la table `rensignebene`
--

CREATE TABLE `rensignebene` (
  `rensignBene_id` int(11) NOT NULL,
  `typeTiers` varchar(50) DEFAULT NULL,
  `idenfifient` int(50) DEFAULT NULL,
  `verification` int(11) DEFAULT 1,
  `deponse_nomber` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rensignebene`
--

INSERT INTO `rensignebene` (`rensignBene_id`, `typeTiers`, `idenfifient`, `verification`, `deponse_nomber`) VALUES
(11, 'Contrôleur', 12986, 1, '7'),
(12, 'Fournisseurs ou soumissionnaires', 112345, 1, '8'),
(13, 'Fournisseurs ou soumissionnaires', 9823, 1, '999');

-- --------------------------------------------------------

--
-- Structure de la table `rensigneref`
--

CREATE TABLE `rensigneref` (
  `rensigneRef_id` int(11) NOT NULL,
  `modePassation` varchar(150) DEFAULT NULL,
  `reference` varchar(50) DEFAULT NULL,
  `object` varchar(250) DEFAULT NULL,
  `distination` varchar(200) DEFAULT NULL,
  `montant` int(11) DEFAULT NULL,
  `delai` varchar(50) DEFAULT NULL,
  `nomber` int(11) DEFAULT NULL,
  `naturPrix` varchar(50) DEFAULT NULL,
  `interetMor` int(11) DEFAULT NULL,
  `ver` int(11) DEFAULT 1,
  `deponse_nomber` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rensigneref`
--

INSERT INTO `rensigneref` (`rensigneRef_id`, `modePassation`, `reference`, `object`, `distination`, `montant`, `delai`, `nomber`, `naturPrix`, `interetMor`, `ver`, `deponse_nomber`) VALUES
(16, 'Paiement anticipé', '202010', 'Object de la depones', 'Distination de la depones', 100000, 'mois', 6, 'Prix unitaire', 120, 1, '7'),
(17, 'Paiement anticipé', '202010', 'Object de la depones', 'Distination de la depones', 100000, 'mois', 6, 'Prix unitaire', 120, 1, '7'),
(18, 'Paiement anticipé', '202010', 'Object de la depones', 'Distination de la depones', 100000, 'mois', 6, 'Prix unitaire', 120, 1, '7'),
(19, 'Paiement anticipé', '202010', 'Object de la depones', 'Distination de la depones', 100000, 'mois', 6, 'Prix unitaire', 120, 1, '7'),
(20, 'Paiement anticipé', '202010', 'Object de la depones', 'Distination de la depones', 100000, 'mois', 6, 'Prix unitaire', 120, 1, '7'),
(21, 'Paiement à terme échu', '20244', 'OOgject', 'sistibnation', 100, 'jour', 120, 'Prix unitaire', 100, 1, '8'),
(22, 'Paiement anticipé', '20209', 'Object', 'Distination ', 1200, 'jour', 20, 'Prix global forfaitaire ', 120, 1, '999');

-- --------------------------------------------------------

--
-- Structure de la table `rensignerege`
--

CREATE TABLE `rensignerege` (
  `rensigneRege_id` int(11) NOT NULL,
  `modePaim` varchar(50) DEFAULT NULL,
  `typeComp` varchar(50) DEFAULT NULL,
  `Ncopmte` int(100) DEFAULT NULL,
  `verification` int(11) DEFAULT 1,
  `deponse_nomber` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rensignerege`
--

INSERT INTO `rensignerege` (`rensigneRege_id`, `modePaim`, `typeComp`, `Ncopmte`, `verification`, `deponse_nomber`) VALUES
(11, 'Paiement par lettre de crédit', 'Compte ribé', 43876543, 1, '7'),
(12, 'Paiement anticipé', 'Compte ribé', 12345678, 1, '8'),
(13, 'Paiement à terme échu', 'Compte ribé', 12234, 1, '999');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `deponse`
--
ALTER TABLE `deponse`
  ADD PRIMARY KEY (`nomber`);

--
-- Index pour la table `gestionengagement`
--
ALTER TABLE `gestionengagement`
  ADD KEY `gestion` (`deponse_nomber`);

--
-- Index pour la table `justification`
--
ALTER TABLE `justification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `just` (`deponse_nomber`);

--
-- Index pour la table `logintable`
--
ALTER TABLE `logintable`
  ADD PRIMARY KEY (`cin`);

--
-- Index pour la table `parcodebudgetaire`
--
ALTER TABLE `parcodebudgetaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pardeponse`
--
ALTER TABLE `pardeponse`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `parmodepaim`
--
ALTER TABLE `parmodepaim`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `parnatureprix`
--
ALTER TABLE `parnatureprix`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `parpassation`
--
ALTER TABLE `parpassation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `partypetiers`
--
ALTER TABLE `partypetiers`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `quantiteetvalue`
--
ALTER TABLE `quantiteetvalue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tva` (`deponse_nomber`);

--
-- Index pour la table `rensignebene`
--
ALTER TABLE `rensignebene`
  ADD PRIMARY KEY (`rensignBene_id`),
  ADD KEY `resgning` (`deponse_nomber`);

--
-- Index pour la table `rensigneref`
--
ALTER TABLE `rensigneref`
  ADD PRIMARY KEY (`rensigneRef_id`),
  ADD KEY `resgning1` (`deponse_nomber`);

--
-- Index pour la table `rensignerege`
--
ALTER TABLE `rensignerege`
  ADD PRIMARY KEY (`rensigneRege_id`),
  ADD KEY `resgning2` (`deponse_nomber`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `justification`
--
ALTER TABLE `justification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `parcodebudgetaire`
--
ALTER TABLE `parcodebudgetaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `pardeponse`
--
ALTER TABLE `pardeponse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `parmodepaim`
--
ALTER TABLE `parmodepaim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `parnatureprix`
--
ALTER TABLE `parnatureprix`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `parpassation`
--
ALTER TABLE `parpassation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `partypetiers`
--
ALTER TABLE `partypetiers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `quantiteetvalue`
--
ALTER TABLE `quantiteetvalue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `rensignebene`
--
ALTER TABLE `rensignebene`
  MODIFY `rensignBene_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `rensigneref`
--
ALTER TABLE `rensigneref`
  MODIFY `rensigneRef_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `rensignerege`
--
ALTER TABLE `rensignerege`
  MODIFY `rensigneRege_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `gestionengagement`
--
ALTER TABLE `gestionengagement`
  ADD CONSTRAINT `gestion` FOREIGN KEY (`deponse_nomber`) REFERENCES `deponse` (`nomber`);

--
-- Contraintes pour la table `justification`
--
ALTER TABLE `justification`
  ADD CONSTRAINT `just` FOREIGN KEY (`deponse_nomber`) REFERENCES `deponse` (`nomber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `quantiteetvalue`
--
ALTER TABLE `quantiteetvalue`
  ADD CONSTRAINT `tva` FOREIGN KEY (`deponse_nomber`) REFERENCES `deponse` (`nomber`);

--
-- Contraintes pour la table `rensignebene`
--
ALTER TABLE `rensignebene`
  ADD CONSTRAINT `resgning` FOREIGN KEY (`deponse_nomber`) REFERENCES `deponse` (`nomber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rensigneref`
--
ALTER TABLE `rensigneref`
  ADD CONSTRAINT `resgning1` FOREIGN KEY (`deponse_nomber`) REFERENCES `deponse` (`nomber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rensignerege`
--
ALTER TABLE `rensignerege`
  ADD CONSTRAINT `resgning2` FOREIGN KEY (`deponse_nomber`) REFERENCES `deponse` (`nomber`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
