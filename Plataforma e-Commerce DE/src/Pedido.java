import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private String id;
    private Usuario usuario;
    private List<ItemCarrito> items;
    private LocalDateTime fechaPedido;
    private double total;

    public Pedido(String id, Usuario usuario, List<ItemCarrito> items, double total) {
        this.id = id;
        this.usuario = usuario;
        this.items = items;
        this.fechaPedido = LocalDateTime.now();
        this.total = total;
    }
    
    //Getters

    public String getId() { 
    	return id; 
    }
    
    public Usuario getUsuario() {
    	return usuario; 
    }
    
    public List<ItemCarrito> getItems() { 
    	return items; 
    }
    
    public LocalDateTime getFechaPedido() { 
    	return fechaPedido; 
    }
    
    public double getTotal() { 
    	return total; 
    }
    
    
}
