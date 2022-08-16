CREATE PROC DELETE_TABLES
AS
BEGIN
   DROP TABLE Ejercicio_x_Entrenamiento
   DROP TABLE Ejercicio
   DROP TABLE Entrenamiento_x_Futbolista
   DROP TABLE Entrenamiento_x_Equipo
   DROP TABLE Entrenamiento
   DROP TABLE Entrenador
   DROP TABLE Futbolista
   DROP TABLE Socio
   DROP TABLE Copa
   DROP TABLE Liga
   DROP TABLE Equipo_x_Torneo
   DROP TABLE Torneo
   DROP TABLE Empleado
   DROP TABLE Equipo
   DROP TABLE FA
   DROP TABLE Usuario
   DROP TABLE EntradaConEstacionamiento
   DROP TABLE EntradaConComida
   DROP TABLE Entrada
END
GO

EXEC DELETE_TABLES