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

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria)
    VALUES ('Chevrolet', 'Celta', 'AAA-0000', '2015', 'Preto', 10000.00);

INSERT INTO pessoas (nome, cpf, email, telefone)
    VALUES ('Matheus', '111.111.111-11', 'email.generico@gmail.com', '(85) 11111-1111');