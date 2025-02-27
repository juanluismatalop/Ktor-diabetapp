CREATE TABLE User (
    email VARCHAR(255) UNIQUE NOT NULL PRIMARY KEY,
    contrasenna VARCHAR(255) NOT NULL,
    ratioMananna FLOAT NOT NULL,
    ratioMedioDia FLOAT NOT NULL,
    ratioTarde FLOAT NOT NULL,
    ratioNoche FLOAT NOT NULL,
    factorSensibilidad FLOAT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla de usuarios';

INSERT INTO User (id, email, contrasenna, ratioMananna, ratioMedioDia, ratioTarde, ratioNoche, factorSensibilidad) VALUES
(1, 'juan@example.com', 'hashedpassword1', 1.2, 1.5, 1.3, 1.1, 0.9),
(2, 'maria@example.com', 'hashedpassword2', 1.1, 1.4, 1.2, 1.0, 1.0),
(3, 'carlos@example.com', 'hashedpassword3', 1.3, 1.6, 1.4, 1.2, 0.8);