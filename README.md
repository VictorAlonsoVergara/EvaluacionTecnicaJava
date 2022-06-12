# EvaluacionTecnicaJava

- Para la construcción del proyecto he hecho uso del lenguaje de programación Java 8 con ayuda de Spring Boot y Maven en el entorno de desarrollo IntelliJ.

- En el archivo properties se encuentran los parámetros respectivos para conectarse a la base de datos local (en este caso la mía) y se encuentran dos endpoints brindados por punkapi: el primero para hacer la búsqueda sin filtros y el segundo para realizar la búsqueda de una cerveza aleatoria.

- Adicionalmente, los 3 servicios solicitados se pueden probar de la siguiente manera: 
  •	Mostrar todas las cervezas disponibles: http://localhost:8080/beers
  •	Búsqueda de cervezas por nombre: http://localhost:8080/beers/Whisky
  •	Recomendar una cerveza de forma aleatoria: http://localhost:8080/beers/random
