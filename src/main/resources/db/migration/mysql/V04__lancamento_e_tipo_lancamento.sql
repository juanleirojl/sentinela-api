-- -----------------------------------------------------
-- Table tipolancamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipolancamento (
       id INT NOT NULL,
       nome NVARCHAR(255) NOT NULL,
       dataCriacao DATETIME NOT NULL,
       PRIMARY KEY (id))
    ENGINE = InnoDB;

insert into tipolancamento values (1,'RECEITA',now());
insert into tipolancamento values (2,'DESPESA',now());
-- -----------------------------------------------------
-- Table lancamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS lancamento (
    id INT NOT NULL,
    descricao NVARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    dataPagamento DATETIME NOT NULL,
    dataVencimento DATETIME NOT NULL,
    idConta INT NOT NULL,
    idTipoLancamento INT NOT NULL,
    idCategoria INT NOT NULL,
    idUsuario INT NOT NULL,
    dataCriacao DATETIME NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_lancamento_conta_idx (idConta ASC) VISIBLE,
    INDEX fk_lancamento_tipolancamento_idx (idTipoLancamento ASC) VISIBLE,
    INDEX fk_lancamento_categoria_idx (idCategoria ASC) VISIBLE,
    INDEX fk_lancamento_usuario_idx (idUsuario ASC) VISIBLE,
    CONSTRAINT fk_lancamento_conta1  FOREIGN KEY (idConta)       REFERENCES conta (id),
    CONSTRAINT fk_lancamento_tipolancamento FOREIGN KEY (idTipoLancamento)REFERENCES tipolancamento (id),
    CONSTRAINT fk_lancamento_categoria FOREIGN KEY (idCategoria)   REFERENCES categoria (id),
    CONSTRAINT fk_lancamento_usuario  FOREIGN KEY (idUsuario)      REFERENCES usuario (id))
    ENGINE = InnoDB;

insert into lancamento values (1,'pagamento da conta de luz',1274.00,now(),'2020-05-05',1,2,9,1,now());