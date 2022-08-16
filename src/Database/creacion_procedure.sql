/**
1. Entrada
2. EntradaConComida
3. EntradaConEstacionamiento
4. Usuario
5. FA
6. EQUIPO
7. EMPLEADO
8. TORNEO
9. Equipo_x_Torneo
10. Liga
11. Copa
12. Socio
13. Futbolista
14. Entrenador
15. Entrenamiento
16. Entrenamiento_x_Equipo
17. Entrenamiento_x_Futbolista
18. Ejercicio
19. Ejercicio_x_Entrenamiento
**/

ALTER PROC CREATE_TP_TABLES
AS
BEGIN

    --1. Entrada
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Entrada'
             AND
                   type='U'
     )
        DROP TABLE Entrada
     ELSE
        CREATE TABLE Entrada (
            entrada_id INT NOT NULL IDENTITY PRIMARY KEY,
            precio FLOAT NOT NULL,
            platea NVARCHAR(255) NOT NULL,
            sector NVARCHAR(255) NOT NULL,
            asiento INT NOT NULL
    );

    -- 2. EntradaConComida
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='EntradaConComida'
             AND
                   type='U'
     )
        DROP TABLE EntradaConComida
     ELSE
        CREATE TABLE EntradaConComida (
            entrada_id INT NOT NULL,
            dineroParaComida FLOAT NOT NULL,
            PRIMARY KEY(entrada_id,dineroParaComida)
    );
    ALTER TABLE EntradaConComida
    ADD CONSTRAINT FK_EntradaConComida
    FOREIGN KEY (entrada_id) REFERENCES entrada(entrada_id);


    -- 3. EntradaConEstacionamiento
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='EntradaConEstacionamiento'
             AND
                   type='U'
     )
        DROP TABLE EntradaConEstacionamiento
     ELSE
        CREATE TABLE EntradaConEstacionamiento (
            entrada_id INT NOT NULL,
            numCochera INT NOT NULL,
            PRIMARY KEY(entrada_id,numCochera)
    );
    ALTER TABLE EntradaConEstacionamiento
    ADD CONSTRAINT FK_EntradaConEstacionamiento
    FOREIGN KEY (entrada_id) REFERENCES entrada(entrada_id);

    -- 4. Usuario
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Usuario'
             AND
                   type='U'
     )
        DROP TABLE Usuario
     ELSE
        CREATE TABLE Usuario (
            usuario_id INT NOT NULL IDENTITY PRIMARY KEY,
            email NVARCHAR(255) NOT NULL,
            username NVARCHAR(255) NOT NULL,
            contraHasheada NVARCHAR(255)
    );


    -- 5. FA
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='FA'
             AND
                   type='U'
     )
        DROP TABLE FA
     ELSE
        CREATE TABLE FA (
            fa_id INT NOT NULL PRIMARY KEY
    );

    -- 6. EQUIPO
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Equipo'
             AND
                   type='U'
     )
        DROP TABLE Equipo
     ELSE
        CREATE TABLE Equipo (
            equipo_id INT NOT NULL PRIMARY KEY,
            nombre NVARCHAR(255) NOT NULL,
            pais NVARCHAR(255) NOT NULL,
            ciudad NVARCHAR(255),
            estado NVARCHAR(255),
            usuario_id INT NOT NULL,
            fa_id INT NOT NULL,
    );
    ALTER TABLE Equipo
    ADD CONSTRAINT FK_EquipoUsuario
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id);

    ALTER TABLE Equipo
    ADD CONSTRAINT FK_EquipoFA
    FOREIGN KEY (fa_id) REFERENCES FA(fa_id);

    -- 7. EMPLEADO
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Empleado'
             AND
                   type='U'
     )
        DROP TABLE Empleado
     ELSE
        CREATE TABLE Empleado (
            empleado_id INT NOT NULL PRIMARY KEY,
            nombre NVARCHAR(255) NOT NULL,
            apllido NVARCHAR(255) NOT NULL,
            nacionalidad NVARCHAR(255) NOT NULL,
            edad INT NOT NULL,
            equipo_id INT NOT NULL,
            usuario_id INT NOT NULL,
    );
    ALTER TABLE Empleado
    ADD CONSTRAINT FK_EmpleadoUsuario
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id);

    ALTER TABLE Empleado
    ADD CONSTRAINT FK_EmpleadoEquipo
    FOREIGN KEY (equipo_id) REFERENCES Equipo(equipo_id);

    -- 8. TORNEO
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Torneo'
             AND
                   type='U'
     )
        DROP TABLE Torneo
     ELSE
        CREATE TABLE Torneo (
           torneo_id INT NOT NULL PRIMARY KEY,
           nombre NVARCHAR(255) NOT NULL,
           fa_id INT NOT NULL
    );
    ALTER TABLE Torneo
    ADD CONSTRAINT FK_TorneoFA
    FOREIGN KEY (fa_id) REFERENCES FA(fa_id);

   -- 9. Equipo_x_Torneo
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Equipo_x_Torneo'
             AND
                   type='U'
     )
        DROP TABLE Equipo_x_Torneo
     ELSE
        CREATE TABLE Equipo_x_Torneo (
           equipo_id INT NOT NULL,
           torneo_id INT NOT NULL,
           PRIMARY KEY(equipo_id,torneo_id)
    );
    ALTER TABLE Equipo_x_Torneo
    ADD CONSTRAINT FK_EquipoXTorneoEquipo
    FOREIGN KEY (equipo_id) REFERENCES Equipo(equipo_id);

    ALTER TABLE Equipo_x_Torneo
    ADD CONSTRAINT FK_EquipoXTorneoTorneo
    FOREIGN KEY (torneo_id) REFERENCES Torneo(torneo_id);

    -- 10. Liga
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Liga'
             AND
                   type='U'
     )
        DROP TABLE Liga
     ELSE
        CREATE TABLE Liga (
           torneo_id INT NOT NULL,
           pais NVARCHAR(255) NOT NULL,
           anio INT NOT NULL,
           cantFechas INT NOT NULL,
           PRIMARY KEY(torneo_id,cantFechas)
    );
    ALTER TABLE Liga
    ADD CONSTRAINT FK_LigaTorneo
    FOREIGN KEY(torneo_id) REFERENCES Torneo(torneo_id);

   -- 11. Copa
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Copa'
             AND
                   type='U'
     )
        DROP TABLE Copa
     ELSE
        CREATE TABLE Copa (
           torneo_id INT NOT NULL,
           tipoDeCopa NVARCHAR(255) NOT NULL,
           cantGrupos INT NOT NULL,
           cantEquiposClasif INT NOT NULL,
           PRIMARY KEY(torneo_id,tipoDeCopa)
    );
    ALTER TABLE Copa
    ADD CONSTRAINT FK_CopaTorneo
    FOREIGN KEY(torneo_id) REFERENCES Torneo(torneo_id);


    -- 12. Socio
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Socio'
             AND
                   type='U'
     )
        DROP TABLE Socio
     ELSE
        CREATE TABLE Socio (
         socio_id INT NOT NULL PRIMARY KEY,
         nombre NVARCHAR(255) NOT NULL,
         apellido NVARCHAR(255) NOT NULL,
         fechaNacimiento NVARCHAR(255) NOT NULL,
         tipoSocio NVARCHAR(255) NOT NULL,
         tipoDocumento NVARCHAR(255) NOT NULL,
         documento NVARCHAR(255) NOT NULL,
         mail NVARCHAR(255),
         valorCuota FLOAT NOT NULL,
         entrada_id INT,
         equipo_id INT NOT NULL,
    );
    ALTER TABLE Socio
    ADD CONSTRAINT FK_SocioEntrada
    FOREIGN KEY(entrada_id) REFERENCES Entrada(entrada_id);

    ALTER TABLE Socio
    ADD CONSTRAINT FK_SocioEquipo
    FOREIGN KEY(equipo_id) REFERENCES Equipo(equipo_id);


-- 13. Futbolista
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Futbolista'
             AND
                   type='U'
     )
        DROP TABLE Futbolista
     ELSE
        CREATE TABLE Futbolista (
         empleado_id INT NOT NULL,
         altura FLOAT NOT NULL,
         peso FLOAT NOT NULL,
         PRIMARY KEY(empleado_id,altura,peso)
    );
    ALTER TABLE Futbolista
    ADD CONSTRAINT FK_FutbolistaEmpleado
    FOREIGN KEY(empleado_id) REFERENCES Empleado(empleado_id);

    -- 14. Entrenador
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Entrenador'
             AND
                   type='U'
     )
        DROP TABLE Entrenador
     ELSE
        CREATE TABLE Entrenador (
         empleado_id INT NOT NULL,
         matricula NVARCHAR(255) NOT NULL,
         PRIMARY KEY(empleado_id,matricula)
    );
    ALTER TABLE Entrenador
    ADD CONSTRAINT FK_EntrenadorEmpleado
    FOREIGN KEY(empleado_id) REFERENCES Empleado(empleado_id);

    -- 15. Entrenamiento
    IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Entrenamiento'
             AND
                   type='U'
     )
        DROP TABLE Entrenamiento
     ELSE
        CREATE TABLE Entrenamiento (
         entrenamiento_id INT NOT NULL PRIMARY KEY,
         tipoEntrenamiento NVARCHAR(255) NOT NULL,
   );

   -- 16. Entrenamiento_x_Equipo
   IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Entrenamiento_x_Equipo'
             AND
                   type='U'
     )
        DROP TABLE Entrenamiento_x_Equipo
     ELSE
        CREATE TABLE Entrenamiento_x_Equipo (
         entrenamiento_id INT NOT NULL,
         equipo_id INT NOT NULL,
         PRIMARY KEY(entrenamiento_id,equipo_id)
   );
   ALTER TABLE Entrenamiento_x_Equipo
   ADD CONSTRAINT FK_EntrenamientoXEquipoEquipo
   FOREIGN KEY(equipo_id) REFERENCES Equipo(equipo_id);

   ALTER TABLE Entrenamiento_x_Equipo
   ADD CONSTRAINT FK_EntrenamientoXEquipoEntrenamiento
   FOREIGN KEY(entrenamiento_id) REFERENCES Entrenamiento(entrenamiento_id);

   -- 17. Entrenamiento_x_Futbolista
   IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Entrenamiento_x_Futbolista'
             AND
                   type='U'
     )
        DROP TABLE Entrenamiento_x_Futbolista
     ELSE
        CREATE TABLE Entrenamiento_x_Futbolista (
         entrenamiento_id INT NOT NULL,
         empleado_id INT NOT NULL,
         PRIMARY KEY(entrenamiento_id,empleado_id)
   );
   ALTER TABLE Entrenamiento_x_Futbolista
   ADD CONSTRAINT FK_EntrenamientoXFutbolistaEmpleado
   FOREIGN KEY(empleado_id) REFERENCES Empleado(empleado_id);

   ALTER TABLE Entrenamiento_x_Futbolista
   ADD CONSTRAINT FK_EntrenamientoXFutbolistaEntrenamiento
   FOREIGN KEY(entrenamiento_id) REFERENCES Entrenamiento(entrenamiento_id);


   -- 18. Ejercicio
   IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Ejercicio'
             AND
                   type='U'
     )
        DROP TABLE Ejercicio
     ELSE
        CREATE TABLE Ejercicio (
           ejercicio_id INT NOT NULL PRIMARY KEY,
           nombre NVARCHAR(255) NOT NULL,
           duracion FLOAT
   );


   -- 19. Ejercicio_x_Entrenamiento
   IF EXISTS (
         SELECT name FROM sysobjects
             WHERE name='Ejercicio_x_Entrenamiento'
             AND
                   type='U'
     )
        DROP TABLE Ejercicio_x_Entrenamiento
     ELSE
        CREATE TABLE Ejercicio_x_Entrenamiento (
           ejercicio_id INT NOT NULL,
           entrenamiento_id INT NOT NULL,
           PRIMARY KEY(ejercicio_id,entrenamiento_id)
   );
   ALTER TABLE Ejercicio_x_Entrenamiento
   ADD CONSTRAINT FK_EjercicioXEntrenamientoEjercicio
   FOREIGN KEY(ejercicio_id) REFERENCES Ejercicio(ejercicio_id);

   ALTER TABLE Ejercicio_x_Entrenamiento
   ADD CONSTRAINT FK_EjercicioXEntrenamientoEntrenamiento
   FOREIGN KEY(entrenamiento_id) REFERENCES Entrenamiento(entrenamiento_id);


END
GO

EXEC CREATE_TP_TABLES