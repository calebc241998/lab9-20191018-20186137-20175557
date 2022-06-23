-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema apoca_z
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema apoca_z
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apoca_z` ;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
USE `apoca_z` ;

-- -----------------------------------------------------
-- Table `apoca_z`.`Humanos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Humanos` (
  `idHumanos` CHAR(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`idHumanos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Supervivientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Supervivientes` (
  `idHumanos` CHAR(11) NOT NULL,
  `peso` FLOAT NOT NULL,
  `fuerza` FLOAT NOT NULL,
  `idPareja` CHAR(11) NULL,
  INDEX `fk_Supervivientes_Humanos_idx` (`idHumanos` ASC) VISIBLE,
  PRIMARY KEY (`idHumanos`),
  INDEX `fk_Supervivientes_Supervivientes1_idx` (`idPareja` ASC) VISIBLE,
  CONSTRAINT `fk_Supervivientes_Humanos`
    FOREIGN KEY (`idHumanos`)
    REFERENCES `apoca_z`.`Humanos` (`idHumanos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Supervivientes_Supervivientes1`
    FOREIGN KEY (`idPareja`)
    REFERENCES `apoca_z`.`Supervivientes` (`idHumanos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Objetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Objetos` (
  `idObjetos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `peso` FLOAT NOT NULL,
  `vacuna` TINYINT NOT NULL,
  PRIMARY KEY (`idObjetos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Mochila`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Mochila` (
  `idObjetos` INT NOT NULL,
  `idHumanos` CHAR(11) NOT NULL,
  `stock` INT NOT NULL,
  PRIMARY KEY (`idObjetos`, `idHumanos`),
  INDEX `fk_Objetos_has_Supervivientes_Supervivientes1_idx` (`idHumanos` ASC) VISIBLE,
  INDEX `fk_Objetos_has_Supervivientes_Objetos1_idx` (`idObjetos` ASC) VISIBLE,
  CONSTRAINT `fk_Objetos_has_Supervivientes_Objetos1`
    FOREIGN KEY (`idObjetos`)
    REFERENCES `apoca_z`.`Objetos` (`idObjetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Objetos_has_Supervivientes_Supervivientes1`
    FOREIGN KEY (`idHumanos`)
    REFERENCES `apoca_z`.`Supervivientes` (`idHumanos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Virus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Virus` (
  `idVirus` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVirus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Variante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Variante` (
  `idVariante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idVirus` INT NOT NULL,
  PRIMARY KEY (`idVariante`),
  INDEX `fk_Variante_Virus1_idx` (`idVirus` ASC) VISIBLE,
  CONSTRAINT `fk_Variante_Virus1`
    FOREIGN KEY (`idVirus`)
    REFERENCES `apoca_z`.`Virus` (`idVirus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Tipo` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Zombies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Zombies` (
  `idHumanos` CHAR(11) NOT NULL,
  `fechaInfeccion` DATETIME(6) NOT NULL,
  `idVariante` INT NOT NULL,
  `idTipo` INT NOT NULL,
  `victimas` INT NOT NULL,
  PRIMARY KEY (`idHumanos`),
  INDEX `fk_Zombies_Variante1_idx` (`idVariante` ASC) VISIBLE,
  INDEX `fk_Zombies_Tipo1_idx` (`idTipo` ASC) VISIBLE,
  CONSTRAINT `fk_Zombies_Humanos1`
    FOREIGN KEY (`idHumanos`)
    REFERENCES `apoca_z`.`Humanos` (`idHumanos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zombies_Variante1`
    FOREIGN KEY (`idVariante`)
    REFERENCES `apoca_z`.`Variante` (`idVariante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zombies_Tipo1`
    FOREIGN KEY (`idTipo`)
    REFERENCES `apoca_z`.`Tipo` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apoca_z`.`Efectividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apoca_z`.`Efectividad` (
  `idTipo` INT NOT NULL,
  `idObjetos` INT NOT NULL,
  `porcentaje` INT NOT NULL,
  PRIMARY KEY (`idTipo`, `idObjetos`),
  INDEX `fk_Tipo_has_Objetos_Objetos1_idx` (`idObjetos` ASC) VISIBLE,
  INDEX `fk_Tipo_has_Objetos_Tipo1_idx` (`idTipo` ASC) VISIBLE,
  CONSTRAINT `fk_Tipo_has_Objetos_Tipo1`
    FOREIGN KEY (`idTipo`)
    REFERENCES `apoca_z`.`Tipo` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tipo_has_Objetos_Objetos1`
    FOREIGN KEY (`idObjetos`)
    REFERENCES `apoca_z`.`Objetos` (`idObjetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
