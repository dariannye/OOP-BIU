public class Administrador extends Usuario {

    public Administrador(String nombre, String correoElectronico, String contrasena) {
        super(nombre, correoElectronico, contrasena);
    }

    public void agregarProducto(Producto producto) {
    	//Logica a definir mas adelante
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void actualizarStock(Inventario inventario, int nuevoStock) {
        inventario.setStock(nuevoStock);
    }

    public void eliminarProducto(Producto producto) {
    	//Logica a definir mas adelante
        System.out.println("Producto eliminado: " + producto.getNombre());
    }
}

