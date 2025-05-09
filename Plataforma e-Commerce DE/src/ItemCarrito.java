
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    //Getters

    public Producto getProducto() { 
    	return producto; 
    }
    
    public int getCantidad() { 
    	return cantidad; 
    }
    
    //Setter

    public void setCantidad(int cantidad) { 
    	this.cantidad = cantidad; 
    }

  
}
