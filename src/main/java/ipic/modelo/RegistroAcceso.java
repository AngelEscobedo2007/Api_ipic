package ipic.modelo;
import ipic.interfaces.Mostrable;
import java.time.LocalDateTime;
public class RegistroAcceso implements Mostrable {
 private int idRegistro,idAlumno; private String tipoMovimiento,observaciones; private LocalDateTime fechaHora;
 public RegistroAcceso(int idRegistro,int idAlumno,String tipoMovimiento,LocalDateTime fechaHora,String observaciones){if(idRegistro<=0||idAlumno<=0||fechaHora==null)throw new IllegalArgumentException("Registro inválido");this.idRegistro=idRegistro;this.idAlumno=idAlumno;setTipoMovimiento(tipoMovimiento);this.fechaHora=fechaHora;this.observaciones=observaciones==null||observaciones.isBlank()?"Sin observaciones":observaciones.trim();}
 public int getIdRegistro(){return idRegistro;} public int getIdAlumno(){return idAlumno;}
 public String tipoMovimientoValor(){return tipoMovimiento;} public String observacionesValor(){return observaciones;} public LocalDateTime fechaHoraValor(){return fechaHora;}
 public boolean perteneceA(int id){return idAlumno==id;}
 public void setTipoMovimiento(String v){if(v==null||(!v.equalsIgnoreCase("ENTRADA")&&!v.equalsIgnoreCase("SALIDA")))throw new IllegalArgumentException("El movimiento solo puede ser ENTRADA o SALIDA.");tipoMovimiento=v.toUpperCase();}
 @Override public String mostrarInformacion(){return toString();}
 @Override public String toString(){return "ID Registro: "+idRegistro+"\nID Alumno: "+idAlumno+"\nMovimiento: "+tipoMovimiento+"\nFecha: "+fechaHora+"\nObservaciones: "+observaciones;}
}