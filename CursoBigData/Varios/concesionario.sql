CREATE DATABASE concesionario;
USE concesionario;


CREATE TABLE Clientes (
	id INT AUTO_INCREMENT,
	NIF CHAR(9) NOT NULL UNIQUE,
    nombre VARCHAR(20) NOT NULL,
    dirección VARCHAR(30) NOT NULL,
    ciudad VARCHAR(30) NOT NULL,
    telefono CHAR(9) NOT NULL,
	PRIMARY KEY(id)
);


CREATE TABLE Coches (
	id INT AUTO_INCREMENT,
    matrícula CHAR(7) UNIQUE NOT NULL,
    marca VARCHAR(20) NOT NULL,
    modelo VARCHAR(20) NOT NULL,
    color VARCHAR(20) NOT NULL,
    precio FLOAT NOT NULL,
    fk_id_cliente INT,
	PRIMARY KEY(id),
	FOREIGN KEY (fk_id_cliente) REFERENCES Clientes(id)
);


CREATE TABLE Revisiones (
    id INT AUTO_INCREMENT,
    fk_id_coche INT NOT NULL,
    filtro BOOLEAN NOT NULL,
    aceite BOOLEAN NOT NULL,
    frenos BOOLEAN NOT NULL,
    varios VARCHAR(256),
    PRIMARY KEY(id),
    FOREIGN KEY (fk_id_coche) REFERENCES Coches(id)
);


INSERT INTO Clientes VALUES(NULL, '95421857F', 'Gorka Puyo', 'Calle La Boca, 2', 'Parla', '632514785');
INSERT INTO Clientes VALUES(NULL, '24687200T', 'Kepa Yaso', 'Carretera Imanta, km 3 ', 'Valdecristiano', '677852147');
INSERT INTO Clientes VALUES(NULL, '54788624A', 'Felipe Runo', 'Avenida de la Vuelta, 4', 'Colmenar de Oreja', '633255214');

INSERT INTO Coches VALUES(NULL, '2654JJJ', 'Seta', '600', 'Morado', 25000, 3);
INSERT INTO Coches VALUES(NULL, '2987JKJ', 'Ferrero', 'Testarocher', 'Rojo', 350000, 2);
INSERT INTO Coches VALUES(NULL, '7898KKK', 'PELO', 'Corsa', 'Fucsia', 22500, 1);
INSERT INTO Coches VALUES(NULL, '5483LOL', 'Lambo', 'Zambo', 'Amarillo', 400000, 2);

INSERT INTO Revisiones VALUES(NULL, 1, TRUE, TRUE, FALSE, 'Calibrar la junta de la trócola');
INSERT INTO Revisiones VALUES(NULL, 2, FALSE, TRUE, FALSE, 'Recargar el turbo');
INSERT INTO Revisiones VALUES(NULL, 4, TRUE, TRUE, TRUE, 'Amarrar el tubo de escape');
INSERT INTO Revisiones VALUES(NULL, 2, FALSE, FALSE, TRUE, 'Recargar el turbo');


SELECT * FROM Clientes;
SELECT * FROM Coches;
SELECT * FROM Revisiones;

