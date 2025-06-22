
public abstract class Usuario {
    private String nombre, correoElectronico, contrasena;

    public Usuario(String nombre, String correoElectronico, String contrasena) {
        this.setNombre(nombre);
        this.setCorreoElectronico(correoElectronico);
        this.setContrasena(contrasena);
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
    	if (nombre != null && !nombre.trim().isEmpty()) this.nombre = nombre;
    }
    
    
    public void setCorreoElectronico(String correoElectronico) {
    	if (correoElectronico != null && correoElectronico.contains("@")) this.correoElectronico = correoElectronico;
    }


    public void setContrasena(String contrasena) {
    	if (contrasena != null && contrasena.length() >= 6) this.contrasena = contrasena;
    }

}
