public abstract class GestorInventario {
	
    public abstract void añadirProducto(Producto producto, int cantidad);
    
    public abstract void eliminarProducto(String idProducto);
    
    public abstract void actualizarStock(String idProducto, int cantidad);
}
