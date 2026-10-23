package ipic.modelo;
public class Administrador extends Persona {
 private String usuario,contrasena;
 public Administrador(int id,String nombre,boolean activo,String usuario,String contrasena){super(id,nombre,activo);setUsuario(usuario);setContrasena(contrasena);}
 public String getUsuario(){return "Usuario: "+usuario;}
 public String getContrasena(){return "Contraseña: ********";}
 public void setUsuario(String v){if(v==null||v.trim().isEmpty())throw new IllegalArgumentException("El usuario es obligatorio.");usuario=v.trim();}
 public void setContrasena(String v){if(v==null||v.length()<6)throw new IllegalArgumentException("La contraseña debe tener mínimo 6 caracteres.");contrasena=v;}
 @Override public String getTipoPersona(){return "Tipo: Administrador";}
 @Override public String toString(){return super.toString()+"\n"+getUsuario()+"\n"+getContrasena();}
}