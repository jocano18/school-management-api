#  Escuela Management API - Backend

API REST desarrollada para la gestión integral de alumnos, materias y calificaciones

## Tecnologías Usadas
- **Java 17** y **Spring Boot 3**
- **Spring Data JPA** 
- **PostgreSQL** 
- **Maven** 
- **Docker & Docker Compose** 

## Guía de comandos
* **Carga de Datos:** El sistema incluye un archivo `import.sql` que precarga automáticamente 10 alumnos de prueba al iniciar la aplicación por primera vez.
1.  `git clone https://github.com/jocano18/school-management-api.git` - Clona el repositorio
2.  `docker compose up -d --build ` - Crea la imagen Docker del Backend.
3.  `docker logs -f` - Revisa los logs de la aplicacion.
4.  `docker ps` - Verifica que el contenedor esté corriendo.
5.  `docker stop <container_id>` - Detiene el contenedor del Backend.
6.  `docker-compose down -v` - Detiene los servicios y borra los volúmenes.
### Acceso a la interfaz:
Una vez que el contenedor de Docker esté arriba, puedes acceder en:
 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**
