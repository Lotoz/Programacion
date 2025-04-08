DROP DATABASE IF EXISTS mariaDBEjercicio;
CREATE DATABASE mariaDBEjercicio;

USE mariaDBEjercicio;

CREATE TABLE centro (
	numce INTEGER AUTO_INCREMENT PRIMARY KEY,
	nomce VARCHAR(255) NOT NULL
);

CREATE TABLE departamento (
	numde INTEGER AUTO_INCREMENT PRIMARY KEY,
	numce INTEGER NOT NULL,
	direc VARCHAR(255) NOT NULL,
	tidir INTEGER NOT NULL,
	presu DECIMAL(10,2) NOT NULL,
	depde INTEGER NULL,
	nomde VARCHAR(255) NOT NULL
);

CREATE TABLE empleado (
	numem INTEGER AUTO_INCREMENT PRIMARY KEY,
	numde INTEGER NOT NULL,
	extel VARCHAR(255) NOT NULL,
	fecna DATE NOT NULL,
	fecin DATE NOT NULL,
	salar DECIMAL(10,2) NOT NULL,
	comis DECIMAL(10,2) NOT NULL,
	numhi INTEGER NOT NULL,
	nomem VARCHAR(255) NOT NULL
);

INSERT INTO centro (numce, nomce) VALUES
	(1, 'Malaga'),
	(2, 'Sevilla'),
	(3, 'Madrid'),
	(4, 'Barcelona'),
	(5, 'Granada')
;

INSERT INTO departamento (numde, numce, direc, tidir, presu, depde, nomde) VALUES
	(102, 1, 'Planta 4', 2, 20000, 121, 'Gestion'),
	(110, 2, 'Planta 1', 5, 30500, 121, 'Informatica'),
	(121, 1, 'Planta 2', 3, 50000, NULL, 'Central')
;

INSERT INTO empleado (numem, numde, extel, fecna, fecin, salar, comis, numhi, nomem) VALUES
	(1, 110, '900900000', '1979-01-01', '2007-01-01', 1000, 500, 0, 'Juan'),
	(2, 102, '800800800', '1980-01-01', '2007-01-01', 2000, 1000, 2, 'Luis'),
	(3, 121, '910910910', '1990-02-10', '2017-02-10', 1500, 0, 4, 'Ana'),
	(4, 121, '900900900', '1988-10-01', '2017-10-10', 1800, 200, 3, 'Sebastian'),
	(5, 110, '905905905', '1960-01-10', '2006-01-10', 3000, 0, 5, 'Jose'),
	(6, 121, '902902902', '1970-08-10', '2006-02-01', 2050, 0, 0, 'Andres')
;

