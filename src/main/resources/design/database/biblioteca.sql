-- Crear el esquema biblioteca si no está creado
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Crear la tabla Libro
CREATE TABLE Libro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL
);

-- Crear la tabla Ejemplar
CREATE TABLE Ejemplar (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_ejemplar VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    libro_id BIGINT,
    FOREIGN KEY (libro_id) REFERENCES Libro(id)
);