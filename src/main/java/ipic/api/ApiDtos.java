package ipic.api;
import ipic.modelo.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
public final class ApiDtos {
 private ApiDtos(){}
 public record AlumnoRequest(@NotBlank String matricula,@NotBlank String nombre,@NotBlank String apellidoPaterno,String apellidoMaterno,@Min(1) @Max(6) int semestre,@NotBlank String genero){}
 public record MovimientoRequest(@NotBlank String matricula,@NotBlank String tipoMovimiento,String observaciones){}
 public record IncidenciaRequest(@NotBlank String matricula,@NotBlank String tipoIncidencia,@NotBlank String detalle){}
 public record AlumnoResponse(int id,String nombre,boolean activo,String matricula,String apellidoPaterno,String apellidoMaterno,int semestre,String genero){
  public static AlumnoResponse of(Alumno a){return new AlumnoResponse(a.getId(),a.nombreValor(),a.activoValor(),a.matriculaValor(),a.apellidoPaternoValor(),a.apellidoMaternoValor(),a.getSemestre(),a.generoValor());}
 }
 public record MovimientoResponse(int idRegistro,int idAlumno,String tipoMovimiento,LocalDateTime fechaHora,String observaciones){
  public static MovimientoResponse of(RegistroAcceso r){return new MovimientoResponse(r.getIdRegistro(),r.getIdAlumno(),r.tipoMovimientoValor(),r.fechaHoraValor(),r.observacionesValor());}
 }
 public record IncidenciaResponse(int idIncidencia,int idRegistro,int idAdmin,String tipoIncidencia,String detalle,LocalDateTime fechaRegistro){
  public static IncidenciaResponse of(Incidencia i){return new IncidenciaResponse(i.getIdIncidencia(),i.getIdRegistro(),i.getIdAdmin(),i.tipoIncidenciaValor(),i.detalleValor(),i.fechaRegistroValor());}
 }
}