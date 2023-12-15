

CREATE TABLE Cliente (
    CPF CHAR(11) PRIMARY KEY,
    Nome VARCHAR(255),
    Email VARCHAR(255),
    Tel VARCHAR(20),
    Senha VARCHAR(32)
);

ALTER TABLE Cliente ENGINE = InnoDB;

CREATE TABLE Passagem (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Data_Partida DATE,
    Origem VARCHAR(255),
    fk_Destino_Id INTEGER,
    fk_Promocao_Id INTEGER,
    fk_Companhia_Aerea_Id INTEGER
);

ALTER TABLE Passagem ENGINE = InnoDB;

CREATE TABLE Destino (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    Localizacao VARCHAR(255),
    Preco_Medio NUMERIC(10, 2)
);

ALTER TABLE Destino ENGINE = InnoDB;

CREATE TABLE Promocao (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255),
    Descricao TEXT,
    Data_Inicio DATE,
    Data_Termino DATE,
    Desconto NUMERIC(10,2),
    fk_Destino_Id INTEGER
);

ALTER TABLE Promocao ENGINE = InnoDB;

CREATE TABLE Pedido (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Data_Compra DATETIME,
    Preco_Compra NUMERIC(10,2),
    fk_Cliente_CPF CHAR(11),
    fk_Passagem_Id INTEGER,
    fk_Forma_Pagamento_Id INTEGER
);

ALTER TABLE Pedido ENGINE = InnoDB;

CREATE TABLE Forma_Pagamento (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255)
);

ALTER TABLE Forma_Pagamento ENGINE = InnoDB;

CREATE TABLE Companhia_Aerea (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255)
);

ALTER TABLE Companhia_Aerea ENGINE = InnoDB;
 
ALTER TABLE Passagem ADD CONSTRAINT FK_Passagem_2
    FOREIGN KEY (fk_Destino_Id)
    REFERENCES Destino (Id)
    ON DELETE CASCADE;

ALTER TABLE Passagem ADD CONSTRAINT FK_Passagem_3
    FOREIGN KEY (fk_Promocao_Id)
    REFERENCES Promocao (Id)
    ON DELETE SET NULL;

ALTER TABLE Passagem ADD CONSTRAINT FK_Passagem_4
    FOREIGN KEY (fk_Companhia_Aerea_Id)
    REFERENCES Companhia_Aerea (Id)
    ON DELETE CASCADE;
    
ALTER TABLE Promocao ADD CONSTRAINT FK_Promocao_2
    FOREIGN KEY (fk_Destino_Id)
    REFERENCES Destino (Id)
    ON DELETE CASCADE;
 
ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_2
    FOREIGN KEY (fk_Cliente_CPF)
    REFERENCES Cliente (CPF)
    ON DELETE CASCADE;
 
ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_3
    FOREIGN KEY (fk_Passagem_Id)
    REFERENCES Passagem (Id)
    ON DELETE CASCADE;
 
ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_4
    FOREIGN KEY (fk_Forma_Pagamento_Id)
    REFERENCES Forma_Pagamento (Id)
    ON DELETE CASCADE;