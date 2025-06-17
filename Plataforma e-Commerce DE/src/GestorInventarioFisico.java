
import java.util.HashMap;

public class GestorInventarioFisico extends GestorInventario {
    private HashMap<String, Integer> stockFisico = new HashMap<>();

    @Override
    public void añadirProducto(Producto producto) {
        stockFisico.put(producto.getId(), 10);
        System.out.println("Producto físico añadido: " + producto.getNombre());
    }

    @Override
    public void eliminarProducto(String idProducto) {
        stockFisico.remove(idProducto);
        System.out.println("Producto físico eliminado del inventario.");
    }

    @Override
    public void actualizarStock(String idProducto, int cantidad) {
        if (stockFisico.containsKey(idProducto)) {
            stockFisico.put(idProducto, cantidad);
            System.out.println("Stock físico actualizado para el producto: " + idProducto + "Cantidad actualizada: " + cantidad);
        } else {
            System.out.println("Producto físico no encontrado en inventario.");
        }
    }
}
