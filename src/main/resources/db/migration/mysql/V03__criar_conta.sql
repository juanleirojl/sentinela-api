-- -----------------------------------------------------
-- Table conta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS conta (
          id INT NOT NULL,
          nome NVARCHAR(255) NOT NULL,
          limite DECIMAL(10,2) NOT NULL,
          saldo DECIMAL(10,2) NOT NULL,
          idUsuario INT NOT NULL,
          dataCriacao DATETIME NOT NULL,
          PRIMARY KEY (id),
          INDEX fk_conta_usuario_idx (idUsuario ASC) VISIBLE,
          CONSTRAINT fk_conta_usuario
              FOREIGN KEY (idUsuario)
                  REFERENCES usuario (id)
                  ON DELETE NO ACTION
                  ON UPDATE NO ACTION)
    ENGINE = InnoDB;

insert into conta values (1,'Nubank',5000.00,1325.54,1,now());