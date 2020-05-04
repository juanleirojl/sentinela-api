-- -----------------------------------------------------
-- Table categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS sentinela.categoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome NVARCHAR(255)  NOT NULL,
  idCategoriaPai INT NULL,
  idUsuario INT NOT NULL,
  dataCriacao DATETIME NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_categoria_usuario_idx (idUsuario ASC) VISIBLE,
  CONSTRAINT fk_categoria_usuario
    FOREIGN KEY (idUsuario)
    REFERENCES usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;

insert into categoria values (1,'Moradia',null,1,now());
insert into categoria values (2,'Alimentação',null,1,now());
insert into categoria values (3,'Transporte',null,1,now());
insert into categoria values (4,'Saúde',null,1,now());
insert into categoria values (5,'Lazer',null,1,now());
insert into categoria values (6,'Educação',null,1,now());
insert into categoria values (7,'Outros',null,1,now());


-- MORADIA
insert into categoria values (8,'Aluguel',1,1,now());
insert into categoria values (9,'Condominio',1,1,now());
insert into categoria values (10,'Agua',1,1,now());


-- ALIMENTAÇÃO
insert into categoria values (11,'Supermercado',2,1,now());
insert into categoria values (12,'Restaurante',2,1,now());
insert into categoria values (13,'Bar/Lanche',2,1,now());

-- TRANSPORTE
insert into categoria values (14,'Passagem',3,1,now());
insert into categoria values (15,'Combustivel',3,1,now());
insert into categoria values (16,'Estacionamento',3,1,now());

-- SAUDE
insert into categoria values (17,'Farmácia',4,1,now());
insert into categoria values (18,'Plano de Saúde',4,1,now());
insert into categoria values (19,'Dentista',4,1,now());

-- LAZER
insert into categoria values (20,'Academia',5,1,now());
insert into categoria values (21,'TV por assinatura',5,1,now());
insert into categoria values (22,'Programas Culturais',5,1,now());

-- EDUCAÇÃO
insert into categoria values (23,'Pós Graduação',6,1,now());
insert into categoria values (24,'Curso Udemy',6,1,now());


-- OUTROS
insert into categoria values (25,'Emprestimo',7,1,now());
insert into categoria values (26,'Ração Pet',7,1,now());
insert into categoria values (27,'Presente',7,1,now());