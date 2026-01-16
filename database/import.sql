-- 1. LIMPIEZA
DROP TABLE IF EXISTS notas CASCADE;
DROP TABLE IF EXISTS materias CASCADE;
DROP TABLE IF EXISTS alumnos CASCADE;

-- 2. CREACIÓN DE TABLAS
CREATE TABLE alumnos (
id BIGSERIAL PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
fecha_nacimiento DATE NOT NULL
);

CREATE TABLE materias (
id BIGSERIAL PRIMARY KEY,
nombre VARCHAR(100) UNIQUE NOT NULL,
codigo VARCHAR(100) UNIQUE NOT NULL,
creditos INTEGER NOT NULL
);

CREATE TABLE notas (
id BIGSERIAL PRIMARY KEY,
valor DOUBLE PRECISION NOT NULL,
fecha_registro TIMESTAMP NOT NULL,
alumno_id BIGINT REFERENCES alumnos(id),
materia_id BIGINT REFERENCES materias(id)
);

-- 3. INSERCIÓN DE ALUMNOS (10 registros)
INSERT INTO alumnos (nombre, apellido, email, fecha_nacimiento) VALUES
('Juan', 'Pérez', 'juan.perez@escuela.com', '2005-03-15'),
('María', 'González', 'maria.gonzalez@escuela.com', '2004-07-22'),
('Carlos', 'Rodríguez', 'carlos.rodriguez@escuela.com', '2005-11-08'),
('Ana', 'Martínez', 'ana.martinez@escuela.com', '2004-01-30'),
('Luis', 'López', 'luis.lopez@escuela.com', '2005-05-12'),
('Laura', 'Hernández', 'laura.hernandez@escuela.com', '2004-09-25'),
('Pedro', 'García', 'pedro.garcia@escuela.com', '2005-02-18'),
('Sofía', 'Díaz', 'sofia.diaz@escuela.com', '2004-12-05'),
('Diego', 'Sánchez', 'diego.sanchez@escuela.com', '2005-08-14'),
('Valentina', 'Torres', 'valentina.torres@escuela.com', '2004-06-20');

-- 4. INSERCIÓN DE MATERIAS (10 registros)
INSERT INTO materias (nombre, codigo, creditos) VALUES
('Matemáticas', 'MAT101', 4),
('Física', 'FIS101', 4),
('Química', 'QUI101', 3),
('Historia', 'HIS101', 3),
('Programación', 'PRG101', 5),
('Literatura', 'LIT101', 2),
('Biología', 'BIO101', 3),
('Inglés', 'ENG101', 2),
('Geografía', 'GEO101', 3),
('Filosofía', 'PHI101', 2);

-- 5. INSERCIÓN DE NOTAS (10 registros por defecto)
INSERT INTO notas (valor, fecha_registro, alumno_id, materia_id) VALUES
(4.5, '2026-01-15 08:00:00', 1, 1),
(4.2, '2026-01-15 09:00:00', 2, 2),
(3.8, '2026-01-15 10:00:00', 3, 5),
(4.8, '2026-01-15 11:00:00', 4, 3),
(4.0, '2026-01-15 12:00:00', 5, 5),
(4.3, '2026-01-15 13:00:00', 6, 1),
(3.9, '2026-01-15 14:00:00', 7, 2),
(4.7, '2026-01-15 15:00:00', 8, 8),
(5.0, '2026-01-15 16:00:00', 9, 9),
(4.6, '2026-01-15 17:00:00', 10, 10);