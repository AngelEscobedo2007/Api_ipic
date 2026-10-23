package ipic.modelo;
public class Alumno extends Persona {
 private String matricula,apellidoPaterno,apellidoMaterno,genero; private int semestre;
 public Alumno(int id,String nombre,boolean activo,String matricula,String ap,String am,int semestre,String genero){super(id,nombre,activo);setMatricula(matricula);setApellidoPaterno(ap);setApellidoMaterno(am);setSemestre(semestre);setGenero(genero);}
 public String getMatricula(){return "Matrícula: "+matricula;}
 public String getApellidoPaterno(){return "Apellido paterno: "+apellidoPaterno;}
 public String getApellidoMaterno(){return "Apellido materno: "+apellidoMaterno;}
 public int getSemestre(){return semestre;}
 public String getGenero(){return "Género: "+genero;}
 public String matriculaValor(){return matricula;} public String apellidoPaternoValor(){return apellidoPaterno;} public String apellidoMaternoValor(){return apellidoMaterno;} public String generoValor(){return genero;}
 public void setMatricula(String v){if(v==null||v.trim().isEmpty())throw new IllegalArgumentException("La matrícula es obligatoria.");matricula=v.trim().toUpperCase();}
 public void setApellidoPaterno(String v){if(v==null||v.trim().isEmpty())throw new IllegalArgumentException("El apellido paterno es obligatorio.");apellidoPaterno=v.trim();}
 public void setApellidoMaterno(String v){apellidoMaterno=v==null?"":v.trim();}
 public void setSemestre(int v){if(v<1||v>6)throw new IllegalArgumentException("El semestre debe estar entre 1 y 6.");semestre=v;}
 public void setGenero(String v){if(v==null||v.trim().isEmpty())throw new IllegalArgumentException("El género no puede estar vacío.");genero=v.trim();}
 public boolean tieneMatricula(String v){return v!=null&&matricula.equalsIgnoreCase(v.trim());}
 @Override public String getTipoPersona(){return "Tipo: Alumno";}
 @Override public String toString(){return super.toString()+"\n"+getMatricula()+"\n"+getApellidoPaterno()+"\n"+getApellidoMaterno()+"\nSemestre: "+semestre+"\n"+getGenero();}
}