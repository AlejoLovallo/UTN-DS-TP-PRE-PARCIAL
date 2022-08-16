# UTN-DS-TP-PRE-PARCIAL

 ### *Equipos* *y empleados*

De los equipos interesa conocer su nombre, su ciudad, sus empleados, sus socios y sus entrenamientos.

Hay 2 tipos de empleados distintos: Futbolistas y entrenadores.

De cada futbolista de un equipo nos interesa su nombre, apellido, edad, altura, peso y nacionalidad.

De los Entrenadores interesa conocer su nombre, apellido, edad, nacionalidad. 

### *Socios*

De los socios se necesita saber el nombre, el apellido, el tipo de socio (activo/pleno), el tipo y número de documento, el mail y el valor de la cuota.

### *Torneos*

Existen 2 tipos de competiciones diferentes de las cuales puede participar un equipo: Las ligas y las copas.

De las ligas nos interesa saber su nombre, el año, los equipos que participan y la cantidad de fechas.

Por otro lado, de las copas nos interesa conocer el nombre, el tipo de copa (nacional o internacional), los equipos que participan, la cantidad de grupos y la cantidad de equipos por grupo que clasifican a las rondas eliminatorias. 

Un administrativo de la FA estará a cargo de la registración dichos torneos.

********

### **Requerimientos funcionales:**

- Se debe permitir el alta de  equipos.
- Un equipo debe poder dar de  alta y de baja empleados y socios.
- Los socios tienen diferentes tipos de entradas que varían de precio. Cada socio tiene una entrada que  le permite ingresar a todos los partidos. Existen diferentes tipos de     entradas dependiendo de los servicios a los que quiera acceder dentro del  estadio: 

​		o  Común: Sin ningún tipo de beneficio.

​		o  Con comida: se te brinda una determinada cantidad de dinero para poder usarlo en uno de los restaurantes.

​		o  Con estacionamiento: permite acceder a una cochera fija del estacionamiento del estadio determinada para el socio.

* Se debe permitir el alta de entrenamientos, tanto para los jugadores como para los equipos, teniendo en cuenta que cada uno de éstos puede contener varios ejercicios.

​		o  La máxima duración de un entrenamiento debe ser de 2 hs por dia

- * La máxima duración del conjunto de entrenamientos de un equipo debe ser de 6 hs por dia

- - La máxima duración del conjunto de entrenamientos particulares de un deportista es de 4 hs.

* Un equipo puede pasar por 3 estados diferentes. El primero, denominado GREEN, se alcanza cuando en la temporada actual, el equipo ganó más del 60% de los partidos. Si ganó entre 30% y 60%, estaría en estado YELLOW y si ganó menos de 30% pasaría al estado RED. 

* Si un equipo está en estado GREEN no debe realizar ninguna acción. Si se encuentra en estado YELLOW debe incrementar la duración de todos los ejercicios de los entrenamientos del equipo un 10%. Si se encuentra en estado RED el porcentaje a incrementar será del 25% y los jugadores del equipo deben aumentar el tiempo de sus entrenamientos personales un 5%.

* Cada equipo debe poder saber el promedio de edad de su plantel.

* Cada futbolista debe poder saber la cantidad de goles que hizo en esta temporada.

******

### **Requerimientos No Funcionales:**

- El registro será mediante usuario o email 
- La FA contará con un usuario único administrativo para la     generación de los torneos y la verificación de equipos.
- Tanto los empleados como los equipos tendrán un usuario asignado con el cual van a poder acceder a la     plataforma y ver sus datos correspondientes
- Para la actualización de las     estadísticas que determinan el estado de un equipo se utilizará un     servicio de cron 
- Para la información de tablas,  campeonatos y trofeos se utilizará una base de datos relacional.
