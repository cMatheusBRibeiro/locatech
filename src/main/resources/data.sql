CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valor_diaria DECIMAL(10, 2)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria)
    VALUES ('Chevrolet', 'Celta', 'AAA-0000', '2015', 'Preto', 10000.00);