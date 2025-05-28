import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private List<ItemCarrito> productos;
    private List<Producto> catalogo;

    public CarritoDeCompras(List<Producto> catalogo) {
        this.productos = new ArrayList<>();
        this.catalogo = catalogo;
    }
    
    public List<ItemCarrito> getProductos() {
        return productos;
    }
    
    //Agregar producto por objeto
    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(new ItemCarrito(producto, cantidad));
    }
    
    //Agregar producto por Id
    public void agregarProducto(String productoId, int cantidad) {
        for (Producto p : catalogo) {
            if (p.getId().equals(productoId)) {
                agregarProducto(p, cantidad);
                return;
            }
        }
        System.out.println("Producto con ID " + productoId + " no encontrado.");
    }
    
    //Agregar producto por nombre y precio
    public void agregarProducto(String nombre, double precio, int cantidad) {
        for (Producto p : catalogo) {
            if (p.getNombre().equalsIgnoreCase(nombre) && p.getPrecio() == precio) {
                agregarProducto(p, cantidad);
                return;
            }
        }
        System.out.println("Producto con nombre '" + nombre + "' y precio " + precio + " no encontrado.");
    }

}

