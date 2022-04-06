CREATE TABLE IF NOT EXISTS hoteis(
    id INT auto_increment PRIMARY KEY,
    nomeFilial VARCHAR(64) NOT NULL,
    rua VARCHAR(64) NOT NULL,
    numero VARCHAR(64) NOT NULL,
    cidade VARCHAR(64) NOT NULL,
    estado VARCHAR(64) NOT NULL,
    isFiveStar SMALLINT NOT NULL
);