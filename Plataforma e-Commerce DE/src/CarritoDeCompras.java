import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private List<ItemCarrito> productos;

    public CarritoDeCompras() {
        this.productos = new ArrayList<>();
    }
    
    public List<ItemCarrito> getProductos() {
        return productos;
    }
    
}

