public class Producto {
    private String id, nombre;
    private double precio;
    private int idInventario;

    public Producto(String id, String nombre, double precio, int idInventario) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.idInventario = idInventario;
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

    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }
    
    public void setPrecio(double precio) { 
    	this.precio = precio; 
    }
    
    public void setIdInventario(int idInventario) { 
    	this.idInventario = idInventario; 
    }
    
}

