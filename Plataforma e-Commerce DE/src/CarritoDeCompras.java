import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class CarritoDeCompras {
    private List<ItemCarrito> productos;
    private List<Producto> catalogo;
    private double total;

    public CarritoDeCompras(List<Producto> catalogo) {
        this.productos = new ArrayList<>();
        this.catalogo = catalogo;
        this.total = 0.0;
    }
    
    public List<ItemCarrito> getProductos() {
        return productos;
    }
    
    public double getTotal() {
        return total;
    }
    // Método para calcular el total
    public void calcularTotal() {
        total = 0.0;
        for (ItemCarrito item : productos) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
    }
    
    //Agregar producto por objeto
    public void agregarProducto(Producto producto, int cantidad) {
    	if (producto != null && cantidad > 0) {
            productos.add(new ItemCarrito(producto, cantidad));
            calcularTotal();
        }
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
    
    // Remover producto del carrito por ID
    public void removerProducto(String productoId) {
        Iterator<ItemCarrito> iterator = productos.iterator();
        boolean eliminado = false;

        while (iterator.hasNext()) {
            ItemCarrito item = iterator.next();
            if (item.getProducto().getId().equals(productoId)) {
                iterator.remove();
                eliminado = true;
            }
        }

        if (eliminado) {
            calcularTotal(); // Recalcula el total después de eliminar
            System.out.println("Producto con ID " + productoId + " eliminado del carrito.");
        } else {
            System.out.println("Producto con ID " + productoId + " no se encontró en el carrito.");
        }
    }

}

