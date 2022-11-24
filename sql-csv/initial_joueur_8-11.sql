-- Adminer 4.8.1 MySQL 8.0.31-0ubuntu0.20.04.1 dump

DROP TABLE IF EXISTS `Court`;
CREATE TABLE `Court`
(
    `id_court`  int         NOT NULL AUTO_INCREMENT,
    `nom_court` varchar(30) NOT NULL,
    PRIMARY KEY (`id_court`)
)


DROP TABLE IF EXISTS `Entrainement`;
CREATE TABLE `Entrainement`
(
    `id_entrainement` int  NOT NULL AUTO_INCREMENT,
    `date`            date NOT NULL,
    `joueur`          int  NOT NULL,
    `court`           int  NOT NULL,
    `heure`           time NOT NULL,
    PRIMARY KEY (`id_entrainement`),
    KEY `Entrainement_FK` (`joueur`),
    KEY `Entrainement_FK_1` (`court`),
    CONSTRAINT `Entrainement_FK` FOREIGN KEY (`joueur`) REFERENCES `Joueur` (`id_joueur`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `Entrainement_FK_1` FOREIGN KEY (`court`) REFERENCES `Court` (`id_court`) ON DELETE CASCADE ON UPDATE CASCADE
)


DROP TABLE IF EXISTS `Entraineur`;
CREATE TABLE `Entraineur`
(
    `id_entraineur`       int         NOT NULL AUTO_INCREMENT,
    `nom_entraineur`      varchar(30) NOT NULL,
    `prenom_entraineur`   varchar(20) NOT NULL,
    `date_naissance`      date        NOT NULL,
    `nationalite`         varchar(30) NOT NULL,
    `date_debut_carriere` date        DEFAULT NULL,
    `main`                varchar(15) DEFAULT NULL,
    `meilleur_classement` int         DEFAULT NULL,
    PRIMARY KEY (`id_entraineur`)
)


DROP TABLE IF EXISTS `Equipe`;
CREATE TABLE `Equipe`
(
    `id_equipe`  int NOT NULL AUTO_INCREMENT,
    `nom_equipe` int DEFAULT NULL,
    `joueur1`    int DEFAULT NULL,
    `joueur2`    int DEFAULT NULL,
    PRIMARY KEY (`id_equipe`),
    KEY `Equipe_Joueur1_FK` (`joueur1`),
    KEY `Equipe_Joueur2_FK` (`joueur2`),
    CONSTRAINT `Equipe_Joueur1_FK` FOREIGN KEY (`joueur1`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE,
    CONSTRAINT `Equipe_Joueur2_FK` FOREIGN KEY (`joueur2`) REFERENCES `Joueur` (`id_joueur`) ON UPDATE CASCADE
)


DROP TABLE IF EXISTS `Joueur`;
CREATE TABLE `Joueur`
(
    `id_joueur`           int                                    NOT NULL AUTO_INCREMENT,
    `date_naissance`      date                                   NOT NULL,
    `lieu_naissance`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
    `nationalite`         varchar(30) COLLATE utf8mb4_0900_as_cs NOT NULL,
    `taille`              int                                                           DEFAULT NULL,
    `poids`               float                                                         DEFAULT NULL,
    `classement`          int                                                           DEFAULT NULL,
    `sexe`                varchar(1) COLLATE utf8mb4_0900_as_cs  NOT NULL,
    `main`                varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs   DEFAULT NULL,
    `date_debut_carriere` year                                   NOT NULL,
    `nom_joueur`          varchar(30) COLLATE utf8mb4_0900_as_cs NOT NULL,
    `prenom_joueur`       varchar(20) COLLATE utf8mb4_0900_as_cs NOT NULL,
    `entraineur`          int                                                           DEFAULT NULL,
    PRIMARY KEY (`id_joueur`),
    KEY `Joueur_FK` (`entraineur`),
    CONSTRAINT `Joueur_FK` FOREIGN KEY (`entraineur`) REFERENCES `Entraineur` (`id_entraineur`) ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_as_cs;

INSERT INTO `Joueur` (`id_joueur`, `date_naissance`, `lieu_naissance`, `nationalite`, `taille`, `poids`, `classement`,
                      `sexe`, `main`, `date_debut_carriere`, `nom_joueur`, `prenom_joueur`, `entraineur`)
VALUES (1, ''1984 - 02 - 16 '', ''New-York'', ''Americain'', 1, 74, NULL, ''H'', ''D'', ''2001 '', ''Parkers'',
        ''Peter'', NULL),
       (2, ''1992 - 08 - 07 '', ''Bell Ville'', ''Argentin'', 1, 83, NULL, ''H'', ''D'', ''2017 '', ''Rogers'',
        ''Steve'', NULL),
       (3, ''1998 - 06 - 06 '', ''Sanremo'', ''Italien'', 1, 78, NULL, ''H'', ''G'', ''2018 '', ''Banner'', ''Bruce'',
        NULL),
       (4, ''2000 - 10 - 23 '', ''Rocourt'', ''Belge'', 1, 67, NULL, ''F'', ''G'', ''2018 '', ''Danvers'', ''Carol'',
        NULL),
       (5, ''1999 - 02 - 28 '', ''Hyères'', ''Française'', 1, 60, NULL, ''F'', ''D'', ''2017 '', ''Van Dyne'',
        ''Janet'', NULL),
       (6, ''2000 - 03 - 13 '', ''Rome'', ''Italien'', 1, 89, NULL, ''H'', ''D'', ''2019 '', ''Stark'', ''Tony'', NULL);

DROP TABLE IF EXISTS `Match`;
CREATE TABLE `Match`
(
    `id_match` int  NOT NULL AUTO_INCREMENT,
    `court`    int  NOT NULL,
    `joueur1`  int DEFAULT NULL,
    `joueur2`  int DEFAULT NULL,
    `date`     date NOT NULL,
    `heure`    time NOT NULL,
    `gagnant`  int DEFAULT NULL,
    `equipe1`  int DEFAULT NULL,
    `equipe2`  int DEFAULT NULL,
    `score`    int DEFAULT NULL,
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
)


DROP TABLE IF EXISTS `Score`;
CREATE TABLE `Score`
(
    `nombre_set` tinyint NOT NULL,
    `nombre_jeu` tinyint NOT NULL,
    `id_score`   int     NOT NULL AUTO_INCREMENT,
    `temps`      time    NOT NULL,
    PRIMARY KEY (`id_score`)
)


-- 2022-11-08 14:05:51