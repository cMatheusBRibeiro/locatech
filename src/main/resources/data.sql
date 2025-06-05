CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10, 2)
);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255)
);

CREATE TABLE alugueis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pessoa_id BIGINT NOT NULL,
    veiculo_id BIGINT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pessoa_id)
        REFERENCES pessoas (id),
    FOREIGN KEY (veiculo_id)
        REFERENCES veiculos (id)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria)
    VALUES ('Chevrolet', 'Celta', 'AAA-0000', '2015', 'Preto', 150.00);

INSERT INTO pessoas (nome, cpf, email, telefone)
    VALUES ('Matheus', '111.111.111-11', 'email.generico@gmail.com', '(85) 11111-1111');

INSERT INTO alugueis (pessoa_id, veiculo_id, data_inicio, data_fim, valor_total)
    VALUES (1, 1, '2025-05-23', '2025-05-31', 1200.00);