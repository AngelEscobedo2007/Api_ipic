# IPIC API REST

Sistema IPIC migrado desde Java POO a Spring Boot 3 (Java 17). Almacenamiento en memoria: los datos se pierden al reiniciar.

## Ejecutar
```bash
mvn spring-boot:run
```
Servidor: http://localhost:8080

## Endpoints
- GET /api/salud
- POST /api/alumnos
- GET /api/alumnos
- GET /api/alumnos/{matricula}
- POST /api/accesos
- GET /api/accesos
- POST /api/incidencias
- GET /api/incidencias

### Ejemplos
```bash
curl -X POST http://localhost:8080/api/alumnos -H "Content-Type: application/json" -d '{"matricula":"20260001","nombre":"Ana","apellidoPaterno":"López","apellidoMaterno":"Pérez","semestre":3,"genero":"Femenino"}'
curl -X POST http://localhost:8080/api/accesos -H "Content-Type: application/json" -d '{"matricula":"20260001","tipoMovimiento":"ENTRADA","observaciones":"Sin novedades"}'
curl -X POST http://localhost:8080/api/incidencias -H "Content-Type: application/json" -d '{"matricula":"20260001","tipoIncidencia":"RETARDO","detalle":"Llegó tarde"}'
```

Los endpoints no tienen autenticación: no exponer a Internet con datos reales antes de implementar seguridad y persistencia.
