
public class ProductoFisico extends Producto {
	private double pesoLib;
	private String dimensiones;

	public ProductoFisico(String id, String nombre, double precio, int idInventario, double pesoLib, String dimensiones) {
		super(id, nombre, precio, idInventario);
		this.pesoLib = pesoLib;
        this.dimensiones = dimensiones;
	}
	
	//Getters
    public double getPesoLib() { 
    	return pesoLib; 
    }
    
    public String getDimensiones() { 
    	return dimensiones; 
    }
    
   
    //Setters
    public void setPesoLib(double pesoLib) { 
    	this.pesoLib = pesoLib; 
    }
    
    public void setDimensiones(String dimensiones) {
    	this.dimensiones = dimensiones; 
    }
    
    @Override
    public void mostrarDetalle() {
        System.out.println("Físico [id=" + getId() 
            + ", nombre=" + getNombre() 
            + ", precio=" + getPrecio() 
            + ", peso=" + pesoLib + "lb"
            + ", dimensiones=" + dimensiones + "]");
    }

}
