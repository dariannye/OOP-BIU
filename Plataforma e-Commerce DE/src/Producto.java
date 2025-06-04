public abstract class Producto {
    private String id, nombre;
    private double precio;
    private int idInventario;

    public Producto(String id, String nombre, double precio, int idInventario) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setIdInventario(idInventario);
    }
    
    //Getters

    public String getId() { 
    	return id; 
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public double getPrecio() { 
    	return precio; 
    }
    
    public int getIdInventario() { 
    	return idInventario; 
    }
    
    //Setters
    
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        }
    }

    public void setNombre(String nombre) { 
    	 if (nombre != null && !nombre.trim().isEmpty()) {
             this.nombre = nombre;
         } 
    }
    
    public void setPrecio(double precio) { 
    	  if (precio > 0) {
              this.precio = precio;
          } 
    }
    
    public void setIdInventario(int idInventario) { 
    	this.idInventario = idInventario; 
    }
    

    // Método para mostrar información genérica
    public abstract void mostrarDetalle();
    
}

