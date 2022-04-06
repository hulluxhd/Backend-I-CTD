DROP TABLE IF EXISTS hoteis;

CREATE TABLE IF NOT EXISTS hoteis
(
    id int auto_increment primary key,
    nomeFilial VARCHAR(64),
    rua VARCHAR(64),
    numero INT,
    cidade VARCHAR(64),
    estado VARCHAR(64),
    estrelas BOOLEAN
    );