-- -----------------------------------------------------
-- Table tipocategoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipocategoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome NVARCHAR(255) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome NVARCHAR(255) NOT NULL,
  idTipoCategoria INT NOT NULL,
  PRIMARY KEY (id, idTipoCategoria),
  INDEX fk_categoria_tipo_categoria_id (idTipoCategoria ASC),
  CONSTRAINT fk_categoria_tipo_categoria
    FOREIGN KEY (idTipoCategoria)
    REFERENCES tipocategoria (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

-- INSERE TIPO CATEGORIA
insert into tipocategoria values (1,'Moradia');
insert into tipocategoria values (2,'Alimentação');
insert into tipocategoria values (3,'Transporte');
insert into tipocategoria values (4,'Saúde');
insert into tipocategoria values (5,'Lazer');
insert into tipocategoria values (6,'Educação');
insert into tipocategoria values (7,'Outros');


-- INSERE CATEGORIA
	-- MORADIA
insert into categoria values (1,'Aluguel',1);
insert into categoria values (2,'Condominio',1);
insert into categoria values (3,'Agua',1);


	-- ALIMENTAÇÃO
insert into categoria values (4,'Supermercado',2);
insert into categoria values (5,'Restaurante',2);
insert into categoria values (6,'Bar/Lanche',2);

	-- TRANSPORTE
insert into categoria values (7,'Passagem',3);
insert into categoria values (8,'Combustivel',3);
insert into categoria values (9,'Estacionamento',3);

	-- SAUDE
insert into categoria values (10,'Farmácia',4);
insert into categoria values (11,'Plano de Saúde',4);
insert into categoria values (12,'Dentista',4);

	-- LAZER
insert into categoria values (13,'Academia',5);
insert into categoria values (14,'TV por assinatura',5);
insert into categoria values (15,'Programas Culturais',5);

	-- EDUCAÇÃO
insert into categoria values (16,'Pós Graduação',6);
insert into categoria values (17,'Curso Udemy',6);


	-- LAZER
insert into categoria values (18,'Emprestimo',7);
insert into categoria values (19,'Ração Pet',7);
insert into categoria values (20,'Presente',7);

