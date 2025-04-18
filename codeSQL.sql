-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gestionpharmacie
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestionpharmacie
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestionpharmacie` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `gestionpharmacie` ;

-- -----------------------------------------------------
-- Table `gestionpharmacie`.`utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`utilisateur` (
  `idutilisateur` INT NOT NULL,
  `nomUtilisateur` VARCHAR(45) NULL DEFAULT NULL,
  `motdepasse` VARCHAR(45) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `adresse` VARCHAR(45) NULL DEFAULT NULL,
  `telephone` VARCHAR(45) NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idutilisateur`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestionpharmacie`.`administrateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`administrateur` (
  `idadministrateur` INT NOT NULL,
  `AnnéEmbauche` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idadministrateur`),
  CONSTRAINT `idadministrateur`
    FOREIGN KEY (`idadministrateur`)
    REFERENCES `gestionpharmacie`.`utilisateur` (`idutilisateur`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestionpharmacie`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`client` (
  `idClient` INT NOT NULL,
  `nomClient` VARCHAR(45) NULL DEFAULT NULL,
  `credit` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE INDEX `idClient_UNIQUE` (`idClient` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestionpharmacie`.`medicament`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`medicament` (
  `idmedicament` INT NOT NULL,
  `nommedicament` VARCHAR(45) NULL DEFAULT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idmedicament`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestionpharmacie`.`ordonnance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`ordonnance` (
  `idordonnance` INT NOT NULL,
  `idclient` INT NULL DEFAULT NULL,
  `mois` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idordonnance`),
  INDEX `idclient_idx` (`idclient` ASC) VISIBLE,
  CONSTRAINT `idclient`
    FOREIGN KEY (`idclient`)
    REFERENCES `gestionpharmacie`.`client` (`idClient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestionpharmacie`.`ordonnance_medicament`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`ordonnance_medicament` (
  `idordonnance` INT NOT NULL,
  `idmedicament` INT NOT NULL,
  PRIMARY KEY (`idordonnance`, `idmedicament`),
  INDEX `idmedicament_idx` (`idmedicament` ASC) VISIBLE,
  CONSTRAINT `idmedicament`
    FOREIGN KEY (`idmedicament`)
    REFERENCES `gestionpharmacie`.`medicament` (`idmedicament`),
  CONSTRAINT `idordonnance`
    FOREIGN KEY (`idordonnance`)
    REFERENCES `gestionpharmacie`.`ordonnance` (`idordonnance`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestionpharmacie`.`pharmacien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestionpharmacie`.`pharmacien` (
  `idpharmacien` INT NOT NULL,
  `annéesExp` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idpharmacien`),
  INDEX `idpharmacien_idx` (`idpharmacien` ASC) VISIBLE,
  CONSTRAINT `idpharmacien`
    FOREIGN KEY (`idpharmacien`)
    REFERENCES `gestionpharmacie`.`utilisateur` (`idutilisateur`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
