package ipic.servicio;
import ipic.modelo.*;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
@Service
public class SistemaIPIC {
 private final List<Alumno> alumnos=new ArrayList<>();
 private final List<RegistroAcceso> registros=new ArrayList<>();
 private final List<Incidencia> incidencias=new ArrayList<>();
 private int idAlumno=1,idRegistro=1,idIncidencia=1;
 public synchronized Alumno registrarAlumno(String matricula,String nombre,String ap,String am,int semestre,String genero){
  if(buscarAlumnoPorMatricula(matricula)!=null)throw new IllegalArgumentException("Ya existe un alumno con esa matrícula.");
  Alumno a=new Alumno(idAlumno++,nombre,true,matricula,ap,am,semestre,genero);alumnos.add(a);return a;
 }
 public synchronized Alumno buscarAlumnoPorMatricula(String matricula){for(Alumno a:alumnos)if(a.tieneMatricula(matricula))return a;return null;}
 public synchronized RegistroAcceso registrarMovimiento(String matricula,String tipo,String obs){
  Alumno a=buscarAlumnoPorMatricula(matricula);if(a==null)throw new NoSuchElementException("Alumno no encontrado");
  RegistroAcceso r=new RegistroAcceso(idRegistro,a.getId(),tipo,LocalDateTime.now(),obs);idRegistro++;registros.add(r);return r;
 }
 public synchronized Incidencia registrarIncidencia(String matricula,String tipo,String detalle){
  Alumno a=buscarAlumnoPorMatricula(matricula);if(a==null)throw new NoSuchElementException("Alumno no encontrado");
  RegistroAcceso ultimo=null;for(int i=registros.size()-1;i>=0;i--)if(registros.get(i).perteneceA(a.getId())){ultimo=registros.get(i);break;}
  if(ultimo==null)throw new IllegalArgumentException("El alumno aún no tiene movimientos.");
  Incidencia x=new Incidencia(idIncidencia,ultimo.getIdRegistro(),1,tipo,detalle,LocalDateTime.now());idIncidencia++;incidencias.add(x);return x;
 }
 public synchronized List<Alumno> obtenerAlumnos(){return List.copyOf(alumnos);}
 public synchronized List<RegistroAcceso> obtenerRegistros(){return List.copyOf(registros);}
 public synchronized List<Incidencia> obtenerIncidencias(){return List.copyOf(incidencias);}
}