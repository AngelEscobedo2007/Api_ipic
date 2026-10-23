package ipic.modelo;
import ipic.interfaces.Mostrable;
public abstract class Persona implements Mostrable {
 private int id; private String nombre; private boolean activo;
 public Persona(int id,String nombre,boolean activo){setId(id);setNombre(nombre);setActivo(activo);}
 public int getId(){return id;}
 public String getNombre(){return "Nombre: "+nombre;}
 public String getActivo(){return "Estado: "+(activo?"Activo":"Inactivo");}
 public String nombreValor(){return nombre;}
 public boolean activoValor(){return activo;}
 public void setId(int id){if(id<0)throw new IllegalArgumentException("El ID no puede ser negativo.");this.id=id;}
 public void setNombre(String nombre){if(nombre==null||nombre.trim().isEmpty())throw new IllegalArgumentException("El nombre no puede estar vacío.");this.nombre=nombre.trim();}
 public void setActivo(boolean activo){this.activo=activo;}
 public abstract String getTipoPersona();
 @Override public String mostrarInformacion(){return toString();}
 @Override public String toString(){return "ID: "+getId()+"\n"+getNombre()+"\n"+getActivo()+"\n"+getTipoPersona();}
}