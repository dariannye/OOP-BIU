import java.util.HashMap;

public class GestorInventarioDigital extends GestorInventario {
    private HashMap<String, Integer> stockDigital = new HashMap<>();

    @Override
    public void añadirProducto(Producto producto) {
        stockDigital.put(producto.getId(), 100); 
        System.out.println("Producto digital añadido: " + producto.getNombre());
    }

    @Override
    public void eliminarProducto(String idProducto) {
        stockDigital.remove(idProducto);
        System.out.println("Producto digital eliminado del inventario.");
    }

    @Override
    public void actualizarStock(String idProducto, int cantidad) {
        if (stockDigital.containsKey(idProducto)) {
            stockDigital.put(idProducto, cantidad);
            System.out.println("Stock digital actualizado para el producto: " + idProducto + "Cantidad actualizada: " + cantidad);
        } else {
            System.out.println("Producto digital no encontrado en inventario.");
        }
    }

}
