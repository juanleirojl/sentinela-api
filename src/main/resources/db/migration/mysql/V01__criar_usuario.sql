-- -----------------------------------------------------
-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
     id INT NOT NULL AUTO_INCREMENT,
     nome NVARCHAR(255) NOT NULL,
     email NVARCHAR(255) NOT NULL,
     senha NVARCHAR(255) NOT NULL,
     ativo TINYINT(1) NOT NULL DEFAULT 1,
     dataCriacao DATETIME NOT NULL,
     PRIMARY KEY (id))
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARACTER SET = utf8;

insert into usuario values (1,'Juan Leiro','juan.leiro@gmailc.com','123',1,now());
