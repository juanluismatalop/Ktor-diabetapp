CREATE TABLE Client (
    email VARCHAR(220) PRIMARY KEY,
    contrasenna VARCHAR(220) NOT NULL,
    ratio_mannana DOUBLE,
    ratio_mediodia DOUBLE,
    ratio_tarde DOUBLE,
    ratio_noche DOUBLE,
    factor_sensibilidad DOUBLE,
);ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='tabla de usuario';
INSERT INTO Employee (id, dni, name, password, description, salary, phone, url_image, disponible, token) VALUES
    ("usuario@gmail.com", "usuario", 2.0, 1.0, 1.0, 1.6, 4.0),
    ("juanluismatalop@gmail.com", "julu2003.", 2.0, 1.0, 1.0, 1.6, 4.0),
    ("davidtienepitochico@gmail.com", "notengopito.", 2.0, 1.0, 1.0, 1.6, 4.0);