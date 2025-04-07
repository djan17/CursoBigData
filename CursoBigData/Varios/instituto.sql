CREATE DATABASE instituto;
USE instituto;

CREATE TABLE Profesores (
	id INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    dni CHAR(9) NOT NULL UNIQUE,
    direccion VARCHAR(200),
    telefono VARCHAR(15),
	PRIMARY KEY(id)
);

CREATE TABLE Alumnos (
	id INT AUTO_INCREMENT,
	expediente VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    fnac date,
	PRIMARY KEY(id)
);

CREATE TABLE Modulos (
	id INT AUTO_INCREMENT,
	codigo VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    fk_id_profesor INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (fk_id_profesor) REFERENCES Profesores(id) ON DELETE SET NULL
);

CREATE TABLE Alumnos_Modulos (
    id INT AUTO_INCREMENT,
    fk_id_alumno INT NOT NULL,
    fk_id_modulo INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (fk_id_alumno) REFERENCES Alumnos(id) ON DELETE SET NULL,
    FOREIGN KEY (fk_id_modulo) REFERENCES Modulos(id) ON DELETE SET NULL
);

CREATE TABLE Cursos (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    fk_id_alumno INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (fk_id_alumno) REFERENCES Alumnos(id) ON DELETE SET NULL
);

INSERT INTO Profesores VALUES(NULL, 'Gorka Puyo', '95421857F', 'Parla',NULL);
INSERT INTO Profesores VALUES(NULL, 'Kepa Yaso', '24687200T', NULL, '685234598');
INSERT INTO Profesores VALUES(NULL, 'Felipe Runo', '54788624A', 'Villaverde', '685234598');

INSERT INTO Alumnos VALUES(NULL, 'X852457', 'Esteban', 'Darra', '2000-10-31');
INSERT INTO Alumnos VALUES(NULL, 'X521477', 'Maruja', 'Mada', '2000-02-28');
INSERT INTO Alumnos VALUES(NULL, 'X789878', 'Carmen', 'Tecata', '2000-06-12');
INSERT INTO Alumnos VALUES(NULL, 'X210230', 'Marco', 'Tarro', '2000-10-01');
INSERT INTO Alumnos VALUES(NULL, 'X552585', 'Oscar', 'Camal', '1999-01-01');

INSERT INTO Modulos VALUES(NULL,'MAT1','Matemáticas 1',1);
INSERT INTO Modulos VALUES(NULL,'MAT2','Matemáticas 2',2);
INSERT INTO Modulos VALUES(NULL,'FIS1','Física 1',1);
INSERT INTO Modulos VALUES(NULL,'QUI1','Química 1',3);

INSERT INTO Alumnos_Modulos VALUES(NULL,1,1);
INSERT INTO Alumnos_Modulos VALUES(NULL,1,3);
INSERT INTO Alumnos_Modulos VALUES(NULL,2,1);
INSERT INTO Alumnos_Modulos VALUES(NULL,2,4);
INSERT INTO Alumnos_Modulos VALUES(NULL,3,2);
INSERT INTO Alumnos_Modulos VALUES(NULL,4,3);
INSERT INTO Alumnos_Modulos VALUES(NULL,5,1);
INSERT INTO Alumnos_Modulos VALUES(NULL,5,3);


INSERT INTO Cursos VALUES(NULL, 'ESO1A', 2);
INSERT INTO Cursos VALUES(NULL, 'ESO1B', 4);
UPDATE Profesores SET direccion = 'Legazpi' WHERE dni ='54788624A';
DELETE FROM Alumnos WHERE expediente = 'X521477';

SELECT * FROM Profesores;
SELECT * FROM Alumnos;
SELECT * FROM Modulos;
SELECT * FROM Alumnos_Modulos;
SELECT * FROM Cursos;

SELECT nombre, apellidos FROM Alumnos WHERE fnac > '2000-01-01'
