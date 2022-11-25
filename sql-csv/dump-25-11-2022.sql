-- Adminer 4.8.1 MySQL 8.0.31-0ubuntu0.20.04.1 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `Court`;
CREATE TABLE `Court` (
                         `id_court` int NOT NULL AUTO_INCREMENT,
                         `nom_court` varchar(30) NOT NULL,
                         PRIMARY KEY (`id_court`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Court` (`id_court`, `nom_court`) VALUES
                                                  (1,	'Gotham'),
                                                  (2,	'Arkham'),
                                                  (3,	'Metropolis'),
                                                  (4,	'Atlantis'),
                                                  (5,	'Xandar');

DROP TABLE IF EXISTS `Entrainement`;
CREATE TABLE `Entrainement` (
                                `id_entrainement` int NOT NULL AUTO_INCREMENT,
                                `date` date NOT NULL,
                                `joueur` int NOT NULL,
                                `court` int NOT NULL,
                                `heure` time NOT NULL,
                                PRIMARY KEY (`id_entrainement`),
                                KEY `Entrainement_FK` (`joueur`),
                                KEY `Entrainement_FK_1` (`court`),
                                CONSTRAINT `Entrainement_FK` FOREIGN KEY (`joueur`) REFERENCES `Joueur` (`id_joueur`) ON DELETE CASCADE ON UPDATE CASCADE,
                                CONSTRAINT `Entrainement_FK_1` FOREIGN KEY (`court`) REFERENCES `Court` (`id_court`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Entrainement` (`id_entrainement`, `date`, `joueur`, `court`, `heure`) VALUES
                                                                                       (2,	'2022-09-06',	2,	2,	'10:00:00'),
                                                                                       (3,	'2022-10-09',	2,	1,	'14:00:00'),
                                                                                       (4,	'2022-12-06',	6,	2,	'16:00:00'),
                                                                                       (6,	'2022-12-25',	6,	2,	'16:22:00');

DROP TABLE IF EXISTS `Entraineur`;
CREATE TABLE `Entraineur` (
                              `id_entraineur` int NOT NULL AUTO_INCREMENT,
                              `nom_entraineur` varchar(30) NOT NULL,
                              `prenom_entraineur` varchar(20) NOT NULL,
                              `date_naissance` date NOT NULL,
                              `nationalite` varchar(30) NOT NULL,
                              `date_debut_carriere` date DEFAULT NULL,
                              `main` varchar(15) DEFAULT NULL,
                              `meilleur_classement` int DEFAULT NULL,
                              PRIMARY KEY (`id_entraineur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Entraineur` (`id_entraineur`, `nom_entraineur`, `prenom_entraineur`, `date_naissance`, `nationalite`, `date_debut_carriere`, `main`, `meilleur_classement`) VALUES
                                                                                                                                                                             (1,	'Pennyworth',	'Alfred',	'1943-05-02',	'Américain',	NULL,	NULL,	NULL),
                                                                                                                                                                             (2,	'Parker',	'May Reilly',	'1962-02-19',	'Américaine',	NULL,	NULL,	NULL),
                                                                                                                                                                             (3,	'Strange',	'Stephen',	'1930-11-18',	'Américain',	NULL,	NULL,	NULL);

DROP TABLE IF EXISTS `Equipe`;
CREATE TABLE `Equipe` (
                          `id_equipe` int NOT NULL AUTO_INCREMENT,
                          `nom_equipe` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                          `joueur1` int DEFAULT NULL,
                          `joueur2` int DEFAULT NULL,
                          PRIMARY KEY (`id_equipe`),
                          KEY `Equipe_Joueur1_FK` (`joueur1`),
                          KEY `Equipe_Joueur2_FK` (`joueur2`),
                          CONSTRAINT `Equipe_Joueur1_FK` FOREIGN KEY (`joueur1`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE,
                          CONSTRAINT `Equipe_Joueur2_FK` FOREIGN KEY (`joueur2`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;

INSERT INTO `Equipe` (`id_equipe`, `nom_equipe`, `joueur1`, `joueur2`) VALUES
                                                                           (1,	'Parker-Rogers',	1,	2),
                                                                           (2,	'Danvers-Van Dyne',	4,	5),
                                                                           (3,	'Stark-Jeussapel',	6,	45),
                                                                           (4,	'Banner-Barton',	3,	47),
                                                                           (5,	'Palmer-Jones',	48,	49);

DROP TABLE IF EXISTS `Joueur`;
CREATE TABLE `Joueur` (
                          `id_joueur` int NOT NULL AUTO_INCREMENT,
                          `date_naissance` date NOT NULL,
                          `lieu_naissance` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
                          `nationalite` varchar(30) COLLATE utf8mb4_0900_as_cs NOT NULL,
                          `taille` int DEFAULT NULL,
                          `poids` float DEFAULT NULL,
                          `classement` int DEFAULT NULL,
                          `sexe` varchar(1) COLLATE utf8mb4_0900_as_cs NOT NULL,
                          `main` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
                          `date_debut_carriere` year NOT NULL,
                          `nom_joueur` varchar(30) COLLATE utf8mb4_0900_as_cs NOT NULL,
                          `prenom_joueur` varchar(20) COLLATE utf8mb4_0900_as_cs NOT NULL,
                          `entraineur` int DEFAULT NULL,
                          PRIMARY KEY (`id_joueur`),
                          KEY `Joueur_FK` (`entraineur`),
                          CONSTRAINT `Joueur_FK` FOREIGN KEY (`entraineur`) REFERENCES `Entraineur` (`id_entraineur`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;

INSERT INTO `Joueur` (`id_joueur`, `date_naissance`, `lieu_naissance`, `nationalite`, `taille`, `poids`, `classement`, `sexe`, `main`, `date_debut_carriere`, `nom_joueur`, `prenom_joueur`, `entraineur`) VALUES
                                                                                                                                                                                                               (1,	'1984-02-16',	'New-York',	'Americain',	179,	74,	NULL,	'H',	'D',	'2001',	'Parker',	'Peter',	1),
                                                                                                                                                                                                               (2,	'1992-08-07',	'Bell Ville',	'Argentin',	185,	83,	NULL,	'H',	'D',	'2017',	'Rogers',	'Steve',	1),
                                                                                                                                                                                                               (3,	'1998-06-06',	'Sanremo',	'Italien',	191,	78,	NULL,	'H',	'G',	'2018',	'Banner',	'Bruce',	3),
                                                                                                                                                                                                               (4,	'2000-10-23',	'Rocourt',	'Belge',	175,	67,	NULL,	'F',	'G',	'2018',	'Danvers',	'Carol',	1),
                                                                                                                                                                                                               (5,	'1999-02-28',	'Hyères',	'Française',	168,	60,	NULL,	'F',	'D',	'2017',	'Van Dyne',	'Janet',	1),
                                                                                                                                                                                                               (6,	'1992-01-01',	'Rome',	'Italien',	181,	89,	NULL,	'H',	'D',	'2013',	'Stark',	'Tony',	2),
                                                                                                                                                                                                               (45,	'1997-11-13',	'San Francisco',	'Americain',	187,	86,	NULL,	'H',	'G',	'2018',	'Jeussapel',	'Groot',	2),
                                                                                                                                                                                                               (47,	'1985-07-23',	'Waverly',	'Americain',	190,	76,	NULL,	'H',	'D',	'2013',	'Barton',	'Clint',	3),
                                                                                                                                                                                                               (48,	'1995-01-10',	'Madrid',	'Espagnol',	172,	62,	NULL,	'F',	'D',	'2016',	'Palmer',	'Christine',	3),
                                                                                                                                                                                                               (49,	'2001-06-10',	'Barcelone',	'Espagnol',	178,	69,	NULL,	'F',	'D',	'2017',	'Jones',	'Michelle',	3);

DROP TABLE IF EXISTS `Matchs`;
CREATE TABLE `Matchs` (
                          `id_match` int NOT NULL AUTO_INCREMENT,
                          `court` int NOT NULL,
                          `joueur1` int DEFAULT NULL,
                          `joueur2` int DEFAULT NULL,
                          `date` date NOT NULL,
                          `heure` time NOT NULL,
                          `gagnant` int DEFAULT NULL,
                          `equipe1` int DEFAULT NULL,
                          `equipe2` int DEFAULT NULL,
                          `score` int DEFAULT NULL,
                          PRIMARY KEY (`id_match`),
                          KEY `Match_J1_FK` (`joueur1`),
                          KEY `Match_J2_FK` (`joueur2`),
                          KEY `Match_Court_FK` (`court`),
                          KEY `Match_Equipe1_FK` (`equipe1`),
                          KEY `Match_Equipe2_FK` (`equipe2`),
                          KEY `Match_Gagnant_FK` (`gagnant`),
                          KEY `Match_Score_FK` (`score`),
                          CONSTRAINT `Match_Court_FK` FOREIGN KEY (`court`) REFERENCES `Court` (`id_court`) ON UPDATE CASCADE,
                          CONSTRAINT `Match_Equipe1_FK` FOREIGN KEY (`equipe1`) REFERENCES `Equipe` (`id_equipe`) ON UPDATE CASCADE,
                          CONSTRAINT `Match_Equipe2_FK` FOREIGN KEY (`equipe2`) REFERENCES `Equipe` (`id_equipe`) ON UPDATE CASCADE,
                          CONSTRAINT `Match_Gagnant_FK` FOREIGN KEY (`gagnant`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE,
                          CONSTRAINT `Match_J1_FK` FOREIGN KEY (`joueur1`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE,
                          CONSTRAINT `Match_J2_FK` FOREIGN KEY (`joueur2`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE,
                          CONSTRAINT `Match_Score_FK` FOREIGN KEY (`score`) REFERENCES `Score` (`id_score`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Matchs` (`id_match`, `court`, `joueur1`, `joueur2`, `date`, `heure`, `gagnant`, `equipe1`, `equipe2`, `score`) VALUES
                                                                                                                                (1,	1,	2,	3,	'2023-08-05',	'16:00:00',	NULL,	NULL,	NULL,	NULL),
                                                                                                                                (2,	2,	48,	4,	'2023-08-07',	'16:30:00',	NULL,	NULL,	NULL,	NULL),
                                                                                                                                (3,	1,	4,	48,	'2022-05-09',	'15:15:00',	4,	NULL,	NULL,	2),
                                                                                                                                (4,	4,	5,	49,	'2022-05-09',	'10:15:00',	3,	NULL,	NULL,	1),
                                                                                                                                (5,	3,	1,	3,	'2022-09-12',	'14:20:00',	NULL,	NULL,	NULL,	NULL);

DROP TABLE IF EXISTS `Score`;
CREATE TABLE `Score` (
                         `nombre_set` tinyint NOT NULL,
                         `nombre_jeu` tinyint NOT NULL,
                         `id_score` int NOT NULL AUTO_INCREMENT,
                         `temps` time NOT NULL,
                         PRIMARY KEY (`id_score`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Score` (`nombre_set`, `nombre_jeu`, `id_score`, `temps`) VALUES
                                                                          (2,	12,	1,	'01:30:40'),
                                                                          (3,	18,	2,	'01:50:40');

DROP TABLE IF EXISTS `Utilisateur`;
CREATE TABLE `Utilisateur` (
                               `id_utilisateur` int NOT NULL AUTO_INCREMENT,
                               `pseudo` varchar(20) COLLATE utf8mb4_0900_as_ci NOT NULL,
                               `mdp` varchar(20) COLLATE utf8mb4_0900_as_ci NOT NULL,
                               `role` char(1) COLLATE utf8mb4_0900_as_ci NOT NULL,
                               PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_ci;

INSERT INTO `Utilisateur` (`id_utilisateur`, `pseudo`, `mdp`, `role`) VALUES
                                                                          (1,	'admin',	'1234',	'A'),
                                                                          (2,	'DamienEditJ',	'1234',	'E'),
                                                                          (3,	'ThomasEditM',	'1234',	'M');

-- 2022-11-25 00:19:54