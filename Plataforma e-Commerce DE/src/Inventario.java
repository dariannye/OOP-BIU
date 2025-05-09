public class Inventario {
    private int id, productoId,stock;

    public Inventario(int id, int productoId, int stock) {
        this.id = id;
        this.productoId = productoId;
        this.stock = stock;
    }
    
    //Getters

    public int getId() { 
    	return id; 
    }
    
    public int getProductoId() { 
    	return productoId; 
    }
    
    public int getStock() { 
    	return stock; 
    }
    
    //Setter

    public void setStock(int stock) { 
    	this.stock = stock; 
    }


}

