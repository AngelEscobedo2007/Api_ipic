package ipic.api;
import ipic.servicio.SistemaIPIC;
import ipic.api.ApiDtos.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestController @RequestMapping("/api")
public class IpicController {
 private final SistemaIPIC sistema;
 public IpicController(SistemaIPIC sistema){this.sistema=sistema;}
 @GetMapping("/salud") public Map<String,String> salud(){return Map.of("estado","ok","servicio","IPIC API");}
 @PostMapping("/alumnos") @ResponseStatus(HttpStatus.CREATED) public AlumnoResponse crear(@Valid @RequestBody AlumnoRequest a){return AlumnoResponse.of(sistema.registrarAlumno(a.matricula(),a.nombre(),a.apellidoPaterno(),a.apellidoMaterno(),a.semestre(),a.genero()));}
 @GetMapping("/alumnos") public List<AlumnoResponse> alumnos(){return sistema.obtenerAlumnos().stream().map(AlumnoResponse::of).toList();}
 @GetMapping("/alumnos/{matricula}") public AlumnoResponse alumno(@PathVariable String matricula){var a=sistema.buscarAlumnoPorMatricula(matricula);if(a==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Alumno no encontrado");return AlumnoResponse.of(a);}
 @PostMapping("/accesos") @ResponseStatus(HttpStatus.CREATED) public MovimientoResponse registrarAcceso(@Valid @RequestBody MovimientoRequest r){return MovimientoResponse.of(sistema.registrarMovimiento(r.matricula(),r.tipoMovimiento(),r.observaciones()));}
 @GetMapping("/accesos") public List<MovimientoResponse> accesos(){return sistema.obtenerRegistros().stream().map(MovimientoResponse::of).toList();}
 @PostMapping("/incidencias") @ResponseStatus(HttpStatus.CREATED) public IncidenciaResponse crearIncidencia(@Valid @RequestBody IncidenciaRequest i){return IncidenciaResponse.of(sistema.registrarIncidencia(i.matricula(),i.tipoIncidencia(),i.detalle()));}
 @GetMapping("/incidencias") public List<IncidenciaResponse> incidencias(){return sistema.obtenerIncidencias().stream().map(IncidenciaResponse::of).toList();}
}