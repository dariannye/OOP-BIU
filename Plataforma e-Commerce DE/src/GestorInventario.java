public abstract class GestorInventario {
	
    public abstract void añadirProducto(Producto producto);
    
    public abstract void eliminarProducto(String idProducto);
    
    public abstract void actualizarStock(String idProducto, int cantidad);
}
