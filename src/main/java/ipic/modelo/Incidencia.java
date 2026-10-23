package ipic.modelo;
import ipic.interfaces.Mostrable;
import java.time.LocalDateTime;
public class Incidencia implements Mostrable {
 private int idIncidencia,idRegistro,idAdmin; private String tipoIncidencia,detalle; private LocalDateTime fechaRegistro;
 public Incidencia(int idIncidencia,int idRegistro,int idAdmin,String tipoIncidencia,String detalle,LocalDateTime fechaRegistro){if(idIncidencia<=0||idRegistro<=0||idAdmin<=0||fechaRegistro==null)throw new IllegalArgumentException("Incidencia inválida");this.idIncidencia=idIncidencia;this.idRegistro=idRegistro;this.idAdmin=idAdmin;setTipoIncidencia(tipoIncidencia);setDetalle(detalle);this.fechaRegistro=fechaRegistro;}
 public int getIdIncidencia(){return idIncidencia;}public int getIdRegistro(){return idRegistro;}public int getIdAdmin(){return idAdmin;}
 public String tipoIncidenciaValor(){return tipoIncidencia;}public String detalleValor(){return detalle;}public LocalDateTime fechaRegistroValor(){return fechaRegistro;}
 public void setTipoIncidencia(String v){if(v==null||v.trim().isEmpty())throw new IllegalArgumentException("El tipo de incidencia es obligatorio.");tipoIncidencia=v.trim().toUpperCase();}
 public void setDetalle(String v){if(v==null||v.trim().isEmpty())throw new IllegalArgumentException("El detalle es obligatorio.");detalle=v.trim();}
 @Override public String mostrarInformacion(){return toString();}
 @Override public String toString(){return "ID Incidencia: "+idIncidencia+"\nID Registro: "+idRegistro+"\nTipo: "+tipoIncidencia+"\nDetalle: "+detalle+"\nFecha: "+fechaRegistro;}
}