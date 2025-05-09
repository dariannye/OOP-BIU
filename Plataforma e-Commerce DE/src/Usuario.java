
public class Usuario {
    private String nombre, correoElectronico, contrasena;

    public Usuario(String nombre, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    public String getContrasena() {
        return contrasena;
    }

  
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
