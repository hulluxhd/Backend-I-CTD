CREATE TABLE IF NOT EXISTS enderecos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(64),
    rua VARCHAR(64),
    cidade VARCHAR(64),
    estado VARCHAR(64)
);