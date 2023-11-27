-- Crear la tabla CLIENTE si no existe
CREATE TABLE IF NOT EXISTS CLIENTE (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       tipo_documento VARCHAR(10) NOT NULL,
                                       numero_documento VARCHAR(20) NOT NULL,
                                       primer_nombre VARCHAR(50),
                                       segundo_nombre VARCHAR(50),
                                       primer_apellido VARCHAR(50),
                                       segundo_apellido VARCHAR(50),
                                       telefono VARCHAR(20),
                                       direccion VARCHAR(100),
                                       ciudad_residencia VARCHAR(50)
);

-- Insertar datos por defecto en la tabla CLIENTE
INSERT INTO CLIENTE (
    tipo_documento,
    numero_documento,
    primer_nombre,
    segundo_nombre,
    primer_apellido,
    segundo_apellido,
    telefono,
    direccion,
    ciudad_residencia
)
VALUES (
           'C',
           '23445322',
           'Jesús',
           'Almircar',
           'Castellanos',
           'Paez',
           '123456789',
           'Calle Falsa 123',
           'Cajica'
       );
